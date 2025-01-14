package sugarVisitors;

import java.util.*;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlrGenerated.L42Lexer;
import antlrGenerated.L42Parser.*;
import ast.Ast;
import ast.Expression;
import ast.Ast.*;
import tools.*;
import tools.Map;
import ast.Expression.BlockContent;
import ast.Expression.Catch;
import ast.Ast.ConcreteHeader;
import ast.Ast.Doc;
import ast.Ast.FieldDec;
import ast.Ast.Header;
import ast.Ast.InterfaceHeader;
import ast.Ast.Mdf;
import ast.Ast.MethodSelector;
import ast.Ast.Type;
import ast.Expression.With.On;
import auxiliaryGrammar.Functions;
import ast.Ast.Op;
import ast.Ast.Parameters;
import ast.Ast.Path;
import ast.Ast.SignalKind;
import ast.Ast.TraitHeader;
import ast.Ast.Type;
import ast.Ast.VarDec;
import ast.Ast.VarDecCE;
import ast.Ast.VarDecE;
import ast.Ast.VarDecXE;
import ast.Expression.*;
import ast.Expression.ClassB.*;

public class ToAst extends AbstractVisitor<Expression>{

  private final class ToAstForMembers extends AbstractVisitor<Member> {
    @Override public Member visitMember(MemberContext ctx) {
      return ctx.children.get(0).accept(this);}

    @Override public Member visitMethodWithType(MethodWithTypeContext ctx) {
      MhtContext h = ctx.mht();
      Doc doc1=(h.docsOpt().get(0)==null)?Doc.empty():parseDoc(h.docsOpt().get(0));
      //Doc doc2=(ctx.docsOpt()==null)?Doc.empty():parseDoc(ctx.docsOpt());
      String name=(h.mDec()==null)?"":h.mDec().getText().replace('\t', '(');
      if(name.endsWith("(")){name=name.substring(0,name.length()-1);}
      Mdf mdf=Ast.Mdf.fromString((h.Mdf()==null)?"":h.Mdf().getText());
      List<Type> ts=new ArrayList<>();
      List<String> names=new ArrayList<>();
      Iterator<TContext> tit=h.t().iterator();
      Iterator<DocsOptContext> dit=h.docsOpt().iterator();
      dit.next();//jump first, called doc1 already
      Type returnType=parseType(tit.next());
      for(XContext x : h.x()){
        names.add(x.getText());
        Type ti=parseType(tit.next());
        ti=ti.withDoc(ti.getDoc().sum(parseDoc(dit.next())));
        ts.add(ti);
      }
      MethodSelector s=MethodSelector.of(name, names);
      List<Type> exceptions=new ArrayList<>();
      if(h.sEx()!=null){
        for(TContext ti:h.sEx().t()){
        exceptions.add(parseType(ti));
        }}
      Optional<Expression> inner=Optional.empty();
      if(ctx.eTopForMethod()!=null){inner=Optional.of(ctx.eTopForMethod().accept(ToAst.this));}
      MethodType mt=new MethodType(h.Refine()!=null,mdf,ts,returnType,exceptions);
      return new MethodWithType(doc1,s, mt, inner,position(ctx));
    }

    @Override public Member visitNestedClass(NestedClassContext ctx) {
      Doc doc=parseDoc(ctx.docsOpt());
      if(ctx.Path().getText().contains("::")){throw Assertions.userErrorAssert("no ::");}//TODO:improve, if can be reached
      String name=ctx.Path().getText();
      Expression inner=ctx.eTop().accept(ToAst.this);
      return new NestedClass(doc, C.of(name), inner,position(ctx));
    }

    @Override public Member visitMethodImplemented(MethodImplementedContext ctx) {
      Doc doc=(ctx.mhs().docsOpt()==null)?Doc.empty():parseDoc(ctx.mhs().docsOpt());
      return new MethodImplemented(doc,parseMethSelector(ctx.mhs().methSelector()),ctx.eTopForMethod().accept(ToAst.this),position(ctx));
      }
  }
  @Override public Expression visitW(WContext ctx) {
    return ctx.children.get(0).accept(this);
  }
  @Override public Expression visitWSimple(WSimpleContext ctx) {
    List<String> xs = new ArrayList<String>();
    List<VarDecXE> is = new ArrayList<VarDecXE>();
    for( IContext i:ctx.i()){is.add(parseI(i));}
    List<VarDecXE> decs = new ArrayList<VarDecXE>();
    List<On> ons=new ArrayList<On>();
    Optional<Expression> defaultE=Optional.of(ctx.block().accept(this));
    return new Expression.With(position(ctx),xs, is, decs, ons, defaultE);
  }
  public Position position(ParserRuleContext ctx) {
    Position p=new Position(facade.Parser.getFileName(),ctx.start.getLine(),ctx.start.getCharPositionInLine(),ctx.stop.getLine(),ctx.stop.getCharPositionInLine(),null);
    return p;
  }
  public Position position(Token ctx) {
    Position p=new Position(facade.Parser.getFileName(),ctx.getLine(),ctx.getCharPositionInLine(),ctx.getLine(),ctx.getCharPositionInLine(),null);
    return p;
  }

  
  @Override public Expression visitWSwitch(WSwitchContext ctx) {
    List<String> xs = new ArrayList<String>();
    for( XContext x:ctx.x()){xs.add(x.getText());}
    List<VarDecXE> is = new ArrayList<VarDecXE>();
    for( IContext i:ctx.i()){is.add(parseI(i));}
    List<VarDecXE> decs = new ArrayList<VarDecXE>();
    for( VarDecContext vd:ctx.varDec()){decs.add(parseRealVDec(vd));}
    List<On> ons=new ArrayList<On>();
    for( OnPlusContext on:ctx.onPlus()){ons.add(parseOnPlus(on));}
    Optional<Expression> defaultE=Optional.empty();
    if(ctx.eTop()!=null)defaultE=Optional.of(ctx.eTop().accept(this));
    return new Expression.With(position(ctx),xs, is, decs, ons, defaultE);
  }


  public static String nameK(TerminalNode s){
    return nameK(s.getText());
  }
  public static String nameK(String c){
    return c;
  }

  public static String nameL(ParseTree s){
    return nameL(s.getText());
  }
  public static String nameL(Token s){
    return nameL(s.getText());
  }
  public static String nameL(String c){
    if(c.endsWith("(") || c.endsWith("\t")) {return c.substring(0,c.length()-1);}
    return c;
  }
  public static String nameU(ParseTree s){
    return nameU(s.getText());
  }
  public static String nameU(String c){
    return c;
  }
  public static Doc parseDoc(ParseTree s){
    if(s==null){return Doc.empty();}//as for empty comment string
    return parseDoc(s.getText().replace('\t','('));
  }
  public static Doc parseDoc(String c){
    if(c.isEmpty()){return Doc.empty();}
    if(c.startsWith("/*")){
      c=c.substring(2,c.lastIndexOf('*'));
      //c=c.substring(2,c.length()-2);
      return Doc.factory(true,c);
      }
    else{
      assert c.startsWith("//"):c;
      StringBuffer res=new StringBuffer();
      boolean skip=false;
      char[] chs=c.toCharArray();
      for(int i=2; i<chs.length;i++){
        char cc=chs[i];
        if(!skip){res.append(cc);}
        if(cc=='\n'){skip=true;}
        if(i>3 && cc=='/' && chs[i-1]=='/'){skip=false;}
      }
      String result=res.toString();
      assert result.charAt(result.length()-1)=='\n':result;
  //    res.append("\n");
      return Doc.factory(false,result);
    }
  }

  //TODO: check if is needed
  @Override public Expression visitTerminal(TerminalNode arg0) {
    Token t=(Token)arg0.getPayload();
    switch(t.getType()){
      case L42Lexer.X: return new Expression.X(position(t),nameL(t));
      case L42Lexer.UnOp:
      case L42Lexer.BoolOp:throw tools.Assertions.codeNotReachable(t.toString());
      default:throw tools.Assertions.codeNotReachable(t.toString());
    }
  }
  @Override public Expression visitBlock(BlockContext ctx) {
    return ctx.children.get(0).accept(this);
    }
  @Override public Expression visitCurlyBlock(CurlyBlockContext ctx) {
    Doc doc=parseDoc(ctx.docsOpt());
    List<BlockContent> contents=new ArrayList<BlockContent>();
    for( BbContext b:ctx.bb()){
      List<VarDec> decs=new ArrayList<VarDec>();
      for(DContext d:b.d()){decs.add(parseVDec(d));}
      assert b.ks()!=null;
      List<Catch> _catch=parseKs(b.ks());
      contents.add(new BlockContent(decs,_catch));
      }
    return new Expression.CurlyBlock(position(ctx),doc, contents);
  }
  private Expression visitRoundBlockAux(ParserRuleContext ctx,DocsOptContext docsOpt, List<BbContext> bB,ETopContext eTop) {
    Doc doc=parseDoc(docsOpt);
    List<BlockContent> contents=new ArrayList<BlockContent>();
    for( BbContext b:bB){
      List<VarDec> decs=new ArrayList<VarDec>();
      for(DContext d:b.d()){decs.add(parseVDec(d));}
      assert b.ks()!=null;
      List<Catch> _catch=parseKs(b.ks());
      contents.add(new BlockContent(decs,_catch));
    }
    Expression inner=eTop.accept(this);
    return new Expression.RoundBlock(position(ctx),doc, inner, contents);
  }
  @Override public Expression visitRoundBlock(RoundBlockContext ctx) {
    return visitRoundBlockAux(ctx,ctx.docsOpt(),ctx.bb(),ctx.eTop());
    }

  private List<Catch> parseKs(KsContext ks) {
    List<Catch> result=new ArrayList<>();
    for( KContext ki:ks.k()){
      assert ki instanceof KContext;//for now //TODO:
      result.add(parseK((KContext)ki));
    }
    return result;
  }
  private Catch parseK(KContext k) {
    if(k.k1()!=null){
      return new Expression.Catch1(position(k),
          SignalKind.fromString(nameK(k.k1().sS().getText())),
          parseType(k.k1().t()),
          nameL(k.k1().X()),
          k.k1().eTop().accept(this));
    }
    if(k.kMany()!=null){
      return new Expression.CatchMany(position(k),
          SignalKind.fromString(nameK(k.kMany().sS().getText())),
          k.kMany().t().stream().map(this::parseType).collect(Collectors.toList()),
          k.kMany().eTop().accept(this)
          );
    }
    if( k.kProp()!=null){
      return new Expression.CatchProp(position(k),
          SignalKind.fromString(nameK(k.kProp().sS().getText())),
          k.kProp().t().stream().map(this::parseType).collect(Collectors.toList()),
          k.kProp().eTop().accept(this)
          );
    }
    throw Assertions.codeNotReachable();
  }

  private On parseOnPlus(OnPlusContext on) {
    List<Type> ts=new ArrayList<Type>();
    for(TContext t: on.t()){ts.add(parseType(t));}
    Expression inner=on.eTop((on.Case()==null)?0:1).accept(this);
    return new On(ts,inner);
  }
  private VarDec parseVDec(DContext d) {
    if(d.nestedClass()!=null){
      return new Ast.VarDecCE((NestedClass)
          d.nestedClass().accept(this.new ToAstForMembers()));
      }
    if(d.eTop()!=null){
      return new Ast.VarDecE(d.eTop().accept(this));
      }
    assert d.varDec()!=null;
    return parseRealVDec(d.varDec());
    }
  private VarDecXE parseRealVDec(VarDecContext vd) {
    TContext tt=vd.t();
    Optional<Type> t=(tt==null)?Optional.<Type>empty():Optional.of(parseType(tt));
    Expression inner=vd.eTop().accept(this);
    return new Ast.VarDecXE(vd.Var()!=null,t,nameL(vd.x()),inner);
    }
  private VarDecXE parseI(IContext vd) {
    TContext tt=vd.t();
    Optional<Type> t=(tt==null)?Optional.<Type>empty():Optional.of(parseType(tt));
    return new Ast.VarDecXE(vd.Var()!=null,t,nameL(vd.x()),vd.eTop().accept(this));
    }
  private Type parseType(TContext t) {
      Doc d=parseDoc(t.docsOpt());
      Ast.Type nt=new Ast.Type(
        Mdf.fromString((t.Mdf()==null)?"":nameK(t.Mdf())),
        Ast.Path.sugarParse(nameU(t.Path())),d);
      if (t.Ph()==null){return nt;}
      return Functions.toPh(nt);
    }
  @Override public Expression visitNudeE(NudeEContext ctx) {
      return ctx.eTop().accept(this);}
  @Override public Expression visitX(XContext ctx) {
    assert ctx.children.size()==1: ctx.children.get(1).getClass();
    if(nameK(ctx.X()).equals("void")){return Expression._void.instance;}
    return new Expression.X(position(ctx),nameL(ctx.X()));
    }

  @Override public Expression visitEAtom(EAtomContext ctx) {
    if(ctx.Path()!=null){
      return addNumParse(ctx,new Expression.EPath(position(ctx),Path.sugarParse(nameU(ctx.Path()))));
        }
    if(ctx.DotDotDot()!=null){
      return new Expression.DotDotDot();
        }
    if(ctx.WalkBy()!=null){
      return new Expression.WalkBy();
        }
    int i=0;
    if(ctx.numParse()!=null){i=1;}
    return addNumParse(ctx,ctx.children.get(i).accept(this));
    }
  @Override public Expression visitHqRound(HqRoundContext ctx) {
    String mx=ctx.HashQX().getText();
    assert mx.endsWith("(");
    assert mx.startsWith("#?");
    mx=mx.substring(2,mx.length()-1);
    RoundContext r = ctx.round();
    Doc doc=parseDoc(r.docsOpt());
    assert !mx.startsWith("\\");
    return new Expression.OperationDispatch(mx,doc,parseMParameters(r.ps()),position(r));
    }
  @Override public Expression visitMxRound(MxRoundContext ctx) {
    String mx=ctx.MX().getText();
    assert mx.endsWith("(");
    mx=mx.substring(0,mx.length()-1);
    RoundContext r = ctx.round();
    Doc doc=parseDoc(r.docsOpt());
    assert !mx.startsWith("#");
    assert !mx.startsWith("\\");
    Expression rcv=new Expression.X(position(ctx),mx);
    //Expression rcv= (mx.startsWith("#"))?new Expression.ContextId(mx):new Expression.X(mx);
    return new Expression.FCall(position(r),rcv,doc,parseMParameters(r.ps()));
    }

  @Override public Expression visitContextId(ContextIdContext ctx) {
    return new Expression.ContextId(ctx.getText());
    }

  @Override public Expression visitClassBReuse(ClassBReuseContext ctx) {
    Doc doc1=Doc.empty();
    if(ctx.docsOpt().size()>=1){doc1=parseDoc(ctx.docsOpt().get(0));}
    //Note: if exists ctx.docsOpt().get(1)) it is ignored.
    assert ctx.getChild(0).getText().equals("{");
    assert ctx.getChild(2).getText().startsWith("reuse");
    String url=ctx.getChild(2).getText();
    url=url.trim();
    List<Member> ms=visitMembers(ctx.member());
    ClassB inner=new ClassB(doc1, new Ast.TraitHeader(),Collections.emptyList(),Collections.emptyList(), ms, position(ctx));
    return new Expression.ClassReuse(inner,url,null);
  }
  @Override public Expression visitClassB(ClassBContext ctx) {
    Doc doc1=parseDoc(ctx.docsOpt().get(0));//the number 1 if present is ignored
    Header h=parseHeader(ctx.header());
    List<Type> supertypes= new ArrayList<>();
    ImplsContext impl = ctx.impls();
    if (impl!=null){
      for(TContext ti: impl.t()){
        supertypes.add(parseType(ti));
        }
      }
    List<Member> ms=visitMembers(ctx.member());
    List<Ast.FieldDec> fs=new ArrayList<>();
    for( FieldDecContext f:ctx.fieldDec()){fs.add(parseFieldDec(f));}
    return new Expression.ClassB(doc1, h,fs,supertypes, ms,position(ctx));
  }
  public List<Member> visitMembers(List<MemberContext> ctxms){
    List<Member> members=new ArrayList<Member>();
    for(MemberContext m:ctxms){members.add(m.accept(
      new ToAstForMembers()));}
    return members;
  }
  private MethodSelector parseMethSelector(MethSelectorContext ctx) {
    List<String> xs=new ArrayList<String>();
    for(XContext x:ctx.x()){xs.add(nameL(x));}
    String name="";
    if(ctx.mDec()!=null){name=nameL(ctx.mDec());}
    return MethodSelector.of(name,xs);
  }
  private Header parseHeader(HeaderContext header) {
    if(header.Interface()!=null){return new Ast.InterfaceHeader();}
    return new Ast.TraitHeader();
    }
  private FieldDec parseFieldDec(FieldDecContext f) {
    return new Ast.FieldDec(f.Var()!=null, parseType(f.t()),nameL(f.x()),parseDoc(f.docsOpt()));
  }
  @Override public Expression visitSignalExpr(SignalExprContext ctx) {
    Expression inner=ctx.eTop().accept(this);
    SignalKind kind=SignalKind.fromString(nameK(ctx.sS().getText()));
    return new Expression.Signal(kind, inner);
    }
  @Override public Expression visitLoopExpr(LoopExprContext ctx) {
    Expression inner=ctx.eTop().accept(this);
    return new Expression.Loop(inner);
    }

  @Override public Expression visitIfExpr(IfExprContext ctx) {
    Expression cond=ctx.eTop(0).accept(this);
    Expression then=ctx.block().accept(this);
    Optional<Expression> _else=Optional.empty();
    assert ctx.eTop().size()<=2;
    if(ctx.eTop().size()==2)_else=Optional.of(ctx.eTop(1).accept(this));
    return new Expression.If(position(ctx),cond, then, _else);
  }
  @Override public Expression visitWhileExpr(WhileExprContext ctx) {
    Expression cond=ctx.eTop().accept(this);
    Expression then=ctx.block().accept(this);
    return new Expression.While(position(ctx),cond, then);

  }

  private Expression addNumParse(EAtomContext ctx,Expression e){
    if(ctx.numParse()!=null){
      e=new Expression.Literal(position(ctx),e, ctx.numParse().getText().replace('\t','('),true);
      }
    return e;
  }
  @Override public Expression visitEUnOp(EUnOpContext ctx) {
      Expression e=ctx.ePost().accept(this);
      Token t=null;
      try{
        t=(Token)((TerminalNode)ctx.children.get(0)).getPayload();
      }catch(ClassCastException ignored){}
      if (t!=null&&t.getType()==L42Lexer.UnOp){
        e=new Expression.UnOp(position(ctx),Op.fromString(t.getText()), e);
        }
      return e;
      }
  @Override public Expression visitEL2(EL2Context ctx) {
    return visitBinOp(ctx);
  }

  @Override public Expression visitEL1(EL1Context ctx) {
    return visitBinOp(ctx);
  }

  @Override public Expression visitEL3(EL3Context ctx) {
    return visitBinOp(ctx);
  }

  @Override public Expression visitETop(ETopContext ctx) {
    return visitBinOp(ctx);
  }
  private Expression visitBinOp(ParserRuleContext ctx) {
    LinkedList<ParseTree> stack=this.getStack(ctx);
    Expression current=stack.pop().accept(this);
    while(!stack.isEmpty()){
      current=new Expression.BinOp(position(ctx),current,
        Op.fromString(stack.pop().getText()),
        ToAst.parseDoc(stack.pop()),
        stack.pop().accept(this));
      }
    if(current instanceof Expression.BinOp){
      current=onNeedMakeRightAssociative((Expression.BinOp)current);
      }
    return current;
    }
  private Expression.BinOp onNeedMakeRightAssociative(Expression.BinOp bop){
    if(bop.getOp().leftAssociative){return bop;}
    return makeRightAssociative(bop);
  }
  private Expression.BinOp makeRightAssociative(Expression.BinOp bop) {
    if(!(bop.getLeft() instanceof Expression.BinOp)){return bop;}
    Expression.BinOp left=(Expression.BinOp)bop.getLeft();
    left=onNeedMakeRightAssociative(left);
    Expression.BinOp bop2=bop.withLeft(left.getRight());
    bop2=makeRightAssociative(bop2);
    return left.withRight(bop2);
}
  private LinkedList<ParseTree> getStack(ParserRuleContext ctx){
      return (ctx.children!=null)?new LinkedList<ParseTree>(ctx.children):new LinkedList<ParseTree>();
  }
  @Override public Expression visitUsing(UsingContext ctx) {
    Path path= Ast.Path.sugarParse(nameU(ctx.Path()));
    Expression inner=ctx.eTop().accept(this);
    String name=nameL(ctx.mCall().m());
    Parameters parameters=this.parseMParameters(ctx.mCall().round().ps());
    Doc docs=parseDoc(ctx.mCall().round().docsOpt());
    return new Expression.Using(path, name, docs,parameters, inner);
  }

  @Override public Expression visitEPost(EPostContext ctx) {
    return visitEPostAux(ctx.children);
  }
    private class VisitEPost extends AbstractVisitor<Expression>{
      Expression e0; VisitEPost(Expression e0){this.e0=e0;}
      @Override public Expression visitDocs(DocsContext ctx) {
        return new Expression.DocE(e0,parseDoc(ctx.Doc()));
      }
      @Override public Expression visitSquare(SquareContext ctx) {
      Doc doc=parseDoc(ctx.docsOpt(0));
      List<Doc> docs=new ArrayList<>();
      List<Parameters> parameterss=new ArrayList<>();
      for(int i=0;i<ctx.ps().size();i++){
        docs.add(parseDoc(ctx.docsOpt(i+1)));
        parameterss.add(parseMParameters(ctx.ps(i)));
      }
      assert parameterss.size()>=1:"last empty one at least should be there";
      Parameters last=parameterss.get(parameterss.size()-1);
      if(!last.getE().isPresent() && last.getEs().isEmpty()){
        parameterss.remove(parameterss.size()-1);
        }
      //parse tree= normal form ending in ";"
      // a]=a;] a;]=a;] a;;]=a;;]   [;]=[;]   [;;]=[;;] [;;;]=[;;;]
      return new Expression.SquareCall(position(ctx),e0, doc, docs, parameterss);
      }
      @Override public Expression visitSquareW(SquareWContext ctx) {
        return new Expression.SquareWithCall(position(ctx),e0, (With)ctx.w().accept(ToAst.this));
      }

      @Override public Expression visitRound(RoundContext ctx) {
        Doc doc=parseDoc(ctx.docsOpt());
        return new Expression.FCall(position(ctx),this.e0,doc,
            parseMParameters(ctx.ps()));
      }

      @Override public Expression visitMCall(MCallContext ctx) {
        Expression.FCall f0=(Expression.FCall)ctx.round().accept(this);
        return new Expression.MCall(this.e0,
          nameL(ctx.m()),f0.getDoc(),f0.getPs(),position(ctx));
      }
      @Override public Expression visitStringParse(StringParseContext ctx) {
        String s=ctx.StringQuote().getText();
        s=s.substring(1,s.length()-1);
        if (!s.contains("\n")){
          return new Expression.Literal(position(ctx),e0,s.replace('\t','('),false);
          }
        String[] ss=s.split("\n");
        for(int i=1; i<ss.length-1;i++){
          assert ss[i].contains("\'"):"||"+ss[i]+"||"+i;
          ss[i]=ss[i].substring(ss[i].indexOf("\'")+1);
        }
        s="";
        for(int i=1; i<ss.length-1;i++){s+=ss[i]+"\n";}
        s=s.replace('\t','(');
        return new Expression.Literal(position(ctx),e0,s,false);
      }
    }
    private Expression visitEPostAux(List<ParseTree> ctxChildren) {
      ParseTree c = ctxChildren.get(0);
      Expression e0=c.accept(this);

      for(int i=1;i<ctxChildren.size();i++){
        ParseTree cc = ctxChildren.get(i);
        if (cc instanceof TerminalNode)continue;//it was a "."
        e0=cc.accept(new VisitEPost(e0));
        }
    return e0;
  }

  private Parameters parseMParameters(PsContext ctx) {
    Optional<Expression> e0=Optional.<Expression>empty();
    List<String> xs=new ArrayList<String>();
    List<Expression> es=new ArrayList<Expression>();
    LinkedList<ParseTree> stack = this.getStack(ctx);
    //TODO: first can be comment
    if(!stack.isEmpty()&& !(stack.getFirst()instanceof TerminalNode)){
      e0=Optional.of(stack.pop().accept(this));
      }
    while(!stack.isEmpty()){
      xs.add(nameL(stack.pop()));
      assert stack.getFirst().getText().equals(":"):"|"+stack.getFirst()+"|";
      stack.pop();
      es.add(stack.pop().accept(this));
    }
    return new Parameters(e0,xs,es);
  }
  public Expression visitXOp(XOpContext ctx) {
    return new BinOp(position(ctx),new X(position(ctx),nameL(ctx.X())),Op.fromString(ctx.EqOp().getText()),parseDoc(ctx.docsOpt()),ctx.eTop().accept(this));
  }
  @Override
  public Expression visitRoundBlockForMethod(RoundBlockForMethodContext ctx) {
    return visitRoundBlockAux(ctx,ctx.docsOpt(),ctx.bb(),ctx.eTop());
    }

  @Override
  public Expression visitETopForMethod(ETopForMethodContext ctx) {
    if(ctx.eTop()!=null){return visitETop(ctx.eTop());}
    return visitEPostAux(ctx.children);
    }
  @Override public Expression visitUseSquare(UseSquareContext ctx) {
    SquareContext sq = ctx.square();
    SquareWContext sqW = ctx.squareW();
    assert sq==null || sqW==null;
    assert sq!=null || sqW!=null;
    if( sq!=null){
      Expression sq2 = this.new VisitEPost(Expression._void.instance).visitSquare(sq);
      assert sq2 instanceof Expression.SquareCall;
      return new Expression.UseSquare(sq2);
    }
    Expression sW2 = sqW.accept(this);
    assert sW2 instanceof Expression.SquareWithCall;
    return new Expression.UseSquare(((SquareWithCall)sW2).getWith());
    }

  }
