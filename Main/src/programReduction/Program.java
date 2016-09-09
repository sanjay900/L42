package programReduction;

import java.util.List;

import ast.Ast;
import ast.Ast.Path;
import ast.ExpCore;
import ast.ExpCore.ClassB;
import tools.Assertions;

public interface Program {//this class will eventually replace auxiliaryDefinitions.Program
  @SuppressWarnings("serial")
  public static class EmptyProgram extends RuntimeException{}
  
  Program pop();//(L,ctxL,ctxLs).pop()=ctxL[L],ctxLs

  Program push(CtxL ctx, ExpCore.ClassB l);//(ctxL[L],ctxLs).push(ctxL,L)=L,ctxL,ctxLs
  
  Program evilPush(ExpCore.ClassB l);
  
  ExpCore.ClassB top();//(L,_).top()=L
  
  Program updateTop(ExpCore.ClassB l);
  //this is the only one that can detect evilPush
  //(L,ctxLs).update(L')=L',ctxLs

  Path _reducePath(Path p);//return null in case of failure
    //ok also this one can be messed up by evilPush
  Program growFellow(Program fellow);
  //(L,ctxL,_).growFellow(p)==p.push(p.top()/ctxL)
    
//program derived operations:
 
  default boolean equiv(Ast.Path p, Ast.Path p1){
    if (p.equals(p1)){return true;}
    if (p.isPrimitive() ||p1.isPrimitive()){return false;}
    if(p.outerNumber()==p1.outerNumber()){return false;}
    if(p.outerNumber()<p1.outerNumber()){
      Path aux=p1; p1=p; p=aux;//swap
      }
    assert p.outerNumber()>p1.outerNumber();
    Path reduced=p;
    while(true){
      reduced=this._reducePath(reduced);
      if(reduced==null){return false;}
      if(reduced.outerNumber()==p1.outerNumber()){
        return reduced.equals(p1);
        }
      }
    }
 
  
  default ExpCore.ClassB get(int n){
    assert n>=0;
    if(n==0){return this.top();}
    else return this.pop().get(n-1);
    }

  default Program push(String c) {
    CtxL splitted=CtxL.split(this.top(), c);
    return new PushedProgram((ClassB)splitted.originalHole(),splitted,this); 
    }

  /*mah -push(L)//non determinism is not relevant if update is not used
  p.push(L)=p.push(ctxL,L)//an evilPush can exist in implementation
  with ctxL[L]=p.top()
  //with p'=p.evilPush(L)   p'.top()==L, p'.pop()==p, p'.update(..) error! 
  */

  default Program navigate(List<String>cs){
    Program res=this;
    for(String c:cs){res=res.push(c);}
    return res;
    }

  default Program navigate(Ast.Path p){
    Program res=this;
    for(int i=0;i<p.outerNumber();i++){res=res.pop();}
    return res.navigate(p.getCBar());
  }
  default ExpCore.ClassB extractClassB(Ast.Path p){
    Program res1=this;
    for(int i=0;i<p.outerNumber();i++){res1=res1.pop();}
    ExpCore.ClassB top=res1.top();
    return auxiliaryGrammar.Program.extractCBar(p.getCBar(),top);
    //TODO: need to become autonomous?
    }
  default Path _reducePath(Path p,CtxL ctx){
    if(p.isPrimitive()){return null;}
    if(p.outerNumber()==0){return null;}
    if(p.outerNumber()>1){
      Path p1=p.setNewOuter(p.outerNumber()-1);
      Path p2=this.pop()._reducePath(p1);
      if (p2==null){return null;}
      assert p2.outerNumber()==p1.outerNumber()-1;
      return p2.setNewOuter(p2.outerNumber()+1);
      }
    assert p.outerNumber()==1;
    List<String> cs = p.getCBar();
    if(cs.isEmpty()){return null;}
    ClassB.Member m=ctx.originalCtxM();
    if(!(m instanceof ClassB.NestedClass)){return null;}
    String ncName=((ClassB.NestedClass)m).getName();
    if(!ncName.equals(cs.get(0))){return null;}
    return Path.outer(p.outerNumber()-1, cs.subList(1, cs.size()));
    }
  }

class FlatProgram implements Program{
    ExpCore.ClassB l;
    FlatProgram(ExpCore.ClassB l){this.l=l;}
    
    public Program pop() { throw new Program.EmptyProgram();}

    public Program push(CtxL ctx, ClassB l) {
      return new PushedProgram(l,ctx,this);
      }
    
    public Program evilPush(ExpCore.ClassB l){return new EvilPushed(l,this);}

    public ClassB top() {return l;}

    public Program updateTop(ClassB l) {return new FlatProgram(l);}

    public Path _reducePath(Path p){return null;}
    
    public boolean equiv(Path p, Path p1) {return p.equals(p1);}

    public Program growFellow(Program fellow) {throw new Program.EmptyProgram();}

    }
class PushedProgram implements Program{
    ClassB newTop;
    CtxL splitPoint;
    Program former;
    public PushedProgram(ClassB newTop, CtxL splitPoint, Program former) {
      this.newTop=newTop;
      this.splitPoint=splitPoint;
      this.former=former;
      assert (!(this.getClass().equals(PushedProgram.class))) || splitPoint.fillHole(newTop).equals(former.top()):
      "";
    }
    public Program pop() { return former;}

    public Program push(CtxL ctx, ClassB l) {
      return new PushedProgram(l,ctx,this);
      }

    public Program evilPush(ExpCore.ClassB l){return new EvilPushed(l,this);}

    public ClassB top() {return newTop;}
   
    public Program updateTop(ClassB l) {return new UpdatedProgram(l,this.splitPoint,this.pop());}

    
    public Path _reducePath(Path p){return _reducePath(p,this.splitPoint);}
    
    @Override
    public Program growFellow(Program fellow) {
    CtxL ctx=this.splitPoint.divide(fellow.top());
    return fellow.push(ctx,(ClassB)ctx.originalHole());
    //(L,ctxL,_).growFellow(p)==p.push(p.top()/ctxL)
    }
}
class UpdatedProgram extends PushedProgram{
  public UpdatedProgram(ClassB newTop, CtxL splitPoint, Program former) {
    super(newTop, splitPoint, former);}
  
  public Program pop() {
    return former.updateTop(splitPoint.fillHole(newTop));
    }
  }

class EvilPushed implements Program{
  ClassB newTop; Program former;
  public EvilPushed(ClassB newTop, Program former) {
    this.newTop=newTop; this.former=former;
    }

  public Program pop() {return former;}

  public Program push(CtxL ctx, ClassB l) {throw Assertions.codeNotReachable();}

  public Program evilPush(ClassB l) {return new EvilPushed(l,this);}

  public ClassB top() {return newTop;}

  public Program updateTop(ClassB l) {throw Assertions.codeNotReachable();}

  public Path _reducePath(Path p) {throw Assertions.codeNotReachable();}

  public Program growFellow(Program fellow) {throw Assertions.codeNotReachable();}
  }