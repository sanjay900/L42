package sugarVisitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import sugarVisitors.Visitor;
import tools.Assertions;
import tools.Match;
import ast.Ast;
import ast.Ast.Doc;
import ast.Ast.MethodSelector;
import ast.Ast.MethodType;
import ast.ExpCore;
import ast.Ast.Path;
import ast.Ast.Position;
import ast.Ast.SignalKind;
import ast.Ast.Type;
import ast.Expression.Catch;
import ast.Expression.ClassReuse;
import ast.Expression.ContextId;
import ast.Expression.WalkBy;

import ast.ExpCore.*;
import ast.ExpCore.Block.*;
import ast.ExpCore.ClassB.Member;
import ast.ExpCore.ClassB.Phase;
import ast.Expression;
public class InjectionOnCore implements Visitor<ExpCore> {
  public ExpCore visit(Expression.Signal s){
    return new Signal(s.getKind(),s.getInner().accept(this),null,null);}
  public ExpCore visit(Expression.Loop s) {
    return new Loop(s.getInner().accept(this));}

  public ExpCore visit(Expression.X s){return new X(s.getP(),s.getInner());}
    public ExpCore visit(Expression._void s){return new _void();}
  public ExpCore visit(Expression.EPath s){return new ExpCore.EPath(s.getP(), s.getInner());}
  public ExpCore visit(Expression.RoundBlock s){
    Doc doc = s.getDoc();
    assert s.getContents().size()<=1:s.getContents();
    List<Dec> decs=new ArrayList<Dec>();
    List<ExpCore.Block.On> ons=new ArrayList<ExpCore.Block.On>();
    ExpCore inner=s.getInner().accept(this);
    if(s.getContents().size()==1){
      Expression.BlockContent c = s.getContents().get(0);
      for(Ast.VarDec d:c.getDecs()){
        assert d instanceof Ast.VarDecXE:
          d;
        Ast.VarDecXE sugarDec=(Ast.VarDecXE)d;
        //assert sugarDec.getT().isPresent() :sugarDec;
        Optional<Type> tt=sugarDec.getT();
        Type t=null; if(tt.isPresent()){t=tt.get();}
        String x=sugarDec.getX();
        ExpCore e=sugarDec.getInner().accept(this);
        decs.add(new Dec(sugarDec.isVar(),t,x,e));
        };//END FOR DECS
      for(Catch k :c.get_catch()){
        assert k instanceof Expression.Catch1;
        Expression.Catch1 k1=(Expression.Catch1)k;
        SignalKind kind=k1.getKind();
        String x=k1.getX();
        assert x.length()>=1;
        ons.add(new ExpCore.Block.On(kind,x,k1.getT(),lift(k1.getInner()),k1.getP()));
        }
      return new Block(doc,decs,inner,ons,s.getP(),null);
      }
    return new Block(doc,decs,inner,Collections.emptyList(),s.getP(),null);
  }
  public ExpCore visit(Expression.ClassB s){
    Doc doc1=s.getDoc1();
    List<Ast.Type> supertypes=s.getSupertypes();
    boolean isInterface=false;
    if(s.getH() instanceof Ast.ConcreteHeader){throw Assertions.codeNotReachable();}
    if(s.getH() instanceof Ast.InterfaceHeader){isInterface=true;}
    List<Member> members=new ArrayList<>();
    for(ast.Expression.ClassB.Member mi: s.getMs()){
      members.add(mi.match(
      m-> new ClassB.NestedClass(m.getDoc(),m.getName(),lift(m.getInner()),m.getP()),
      m-> new ClassB.MethodImplemented(m.getDoc(),m.getS(),lift(m.getInner()),m.getP()),
      m->{  Doc mdoc=m.getDoc();
            Ast.MethodSelector ms=m.getMs();
            MethodType mt=m.getMt();
            ExpCore e=null;
            if(m.getInner().isPresent()){e=lift(m.getInner().get());}
            return new ClassB.MethodWithType(mdoc,ms,mt,e,m.getP());
          })
       );
    }
    ClassB result=new ClassB(doc1,isInterface,supertypes,members,s.getP(),Phase.None,-1);
    return result;
    }
  public ExpCore visit(Expression.MCall s){
    assert !s.getPs().getE().isPresent():s;
    ExpCore receiver=s.getReceiver().accept(this);
    String name=s.getName();
    Doc doc=s.getDoc();
    List<String> xs=s.getPs().getXs();
    List<ExpCore>es=new ArrayList<>();
    for(Expression e:s.getPs().getEs()){es.add(e.accept(this));}
    return new MCall(receiver, MethodSelector.of(name,xs),doc,es,s.getP(),null,null);
  }
  public ExpCore visit(Expression.OperationDispatch s){
    assert !s.getPs().getE().isPresent():s;
    String name=s.getName();
    Doc doc=s.getDoc();
    List<String> xs=s.getPs().getXs();
    List<ExpCore>es=new ArrayList<>();
    for(Expression e:s.getPs().getEs()){es.add(e.accept(this));}
    return new OperationDispatch(MethodSelector.of(name,xs),doc,es,s.getP());
  }

  public ExpCore visit(Expression.Using s){
    assert !s.getPs().getE().isPresent();
    List<String>xs=s.getPs().getXs();
    List<ExpCore>es=new ArrayList<>();
    for(Expression e : s.getPs().getEs()){es.add(e.accept(this));}
    return new Using(s.getPath(),MethodSelector.of(s.getName(),xs),s.getDocs(),es,s.getInner().accept(this));
    }
  public ExpCore visit(WalkBy s) {
    return new ExpCore.WalkBy();
  }
  private ast.ExpCore lift(Expression e){return e.accept(this);}
//private Expression lift(ast.ExpCore e){return e.accept(this);}
  public ExpCore visit(Expression.BinOp s){
    if(s.getOp()!=Expression.BinOp.Op.ColonEqual){
      throw Assertions.codeNotReachable();}
    assert s.getLeft() instanceof Expression.X: s;
    Expression.X x=(Expression.X)s.getLeft();
    return new ExpCore.UpdateVar(lift(s.getRight()),x.getInner() ,s.getDoc(),s.getP());
    }
  public ExpCore visit(Expression.If s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.While s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.With s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.DocE s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.UnOp s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.FCall s){throw Assertions.codeNotReachable(s.toString());}
  public ExpCore visit(Expression.SquareCall s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.SquareWithCall s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.UseSquare s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.CurlyBlock s){throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.DotDotDot s){
    throw Assertions.codeNotReachable();}
  public ExpCore visit(Expression.Literal s){throw Assertions.codeNotReachable();}
  public ExpCore visit(ClassReuse s) {
    ExpCore.ClassB cb=s.getUrlFetched();
    ExpCore.ClassB newStuff=(ClassB)s.getInner().accept(this);
    assert cb!=null;
    assert newStuff!=null;
    assert !newStuff.isInterface();
    if(newStuff.getMs().isEmpty()){return cb;}
    List<Member> ms = new ArrayList<Member>(cb.getMs());
    ms.addAll(newStuff.getMs());
    return cb
      .withP(cb.getP().sum(newStuff.getP()))
      .withDoc1(cb.getDoc1().sum(newStuff.getDoc1()))
      .withMs(ms);
    }
  @Override public ExpCore visit(ContextId s){throw Assertions.codeNotReachable();}
}
