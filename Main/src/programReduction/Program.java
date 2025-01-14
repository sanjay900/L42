package programReduction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ast.Ast;
import ast.Ast.C;
import ast.Ast.Doc;
import ast.Ast.Path;
import ast.Ast.Type;
import ast.Ast.Position;
import ast.ErrorMessage;
import ast.ExpCore;
import ast.L42F;
import ast.ExpCore.ClassB;
import ast.ExpCore.ClassB.Phase;
import ast.PathAux;
import auxiliaryGrammar.Functions;
import coreVisitors.From;
import coreVisitors.IsCompiled;
import facade.PData;
import newTypeSystem.ErrorKind;
import tools.Assertions;
import tools.StreamUtils;

public interface Program {
  @SuppressWarnings("serial")
  public static class EmptyProgram extends RuntimeException{}

  Program pop();//(L,ctxL,ctxLs).pop()=ctxL[L],ctxLs

  Program push(CtxL ctx, ExpCore.ClassB l);//(ctxL[L],ctxLs).push(ctxL,L)=L,ctxL,ctxLs

  //well, it is a primitive but always has the same implementation
  default Program evilPush(ExpCore.ClassB l){return new EvilPushed(l,this);}

  ExpCore.ClassB top();//(L,_).top()=L

  Program updateTop(ExpCore.ClassB l);
  //this is the only one that can detect evilPush
  //(L,ctxLs).update(L')=L',ctxLs

  Path _reducePath(Path p);//return null in case of failure
    //ok also this one can be messed up by evilPush
  Program growFellow(Program fellow);
  //(L,ctxL,_).growFellow(p)==p.push(p.top()/ctxL)
  int getFreshId();//good for debugging and needed for reduction

  List<Object> exploredWay();

  List<ExpCore.ClassB.MethodWithType> methods(Ast.Path p);

  //program derived operations:

  default boolean subtypeEq(Ast.Type tSub,Ast.Type tSuper){
    if(!Functions.isSubtype(tSub.getMdf(),tSuper.getMdf())){return false;}
    return this.subtypeEq(tSub.getPath(),tSuper.getPath());
    }

  default boolean subtypeEq(Ast.Path p,Ast.Path p1){
    if(p1.equals(Path.Any())){return true;}
    if(equiv(p,p1)){return true;}
    ClassB cb=this.extractClassB(p);
    for(Path pi:cb.getSuperPaths()){
      if(equiv(From.fromP(pi,p), p1)){return true;}
      }
    return false;
    }
  //hint for testing: p.equiv(p0,p1)==p.navigate(p0).equals(p.navigate(p1))
  //provided both navigates do not throw evilPush errors
  //and p0, p1 already exists (not still to metaprogram their outers)
  default boolean equiv(Ast.Path p, Ast.Path p1){
    if (p.equals(p1)){return true;}
    if (p.isPrimitive() ||p1.isPrimitive()){return false;}
    if(p.outerNumber()==p1.outerNumber()){return false;}
    boolean isP1=p.outerNumber()<p1.outerNumber();
    if(isP1){Path tmp=p1;p1=p;p=tmp;}//p1 is less
    while(true){
      p=this._reducePath(p);
      if(p==null){return false;}
      if(p.outerNumber()==p1.outerNumber()){
        return p.equals(p1);
        }
      }
    }

  default List<Path> minimizeList(Collection<Path> Ps) { return Ps.stream().map(this::minimize).collect(Collectors.toList()); }
  default Type minimize(Type T) { return T.withPath(this.minimize(T.getPath())); }
  default Path minimize(Path p) {
    Path pReduced=p;
    while(pReduced!=null){//reduce pi as much as possible
      p=pReduced;
      pReduced=this._reducePath(p);
      }
    return p;
    }
  default boolean noUnique(Ast.Path p){
    for(C c:minimize(p).getCBar()){
      if(c.isUnique()){return false;}
      }
    return true;
    }
  default List<Ast.C> _equivSubPath(Ast.Path p, Ast.Path pLong){
    if (p.equals(pLong)){return Collections.emptyList();}
    if (p.isPrimitive() ||pLong.isPrimitive()){return null;}
    if(p.outerNumber()==pLong.outerNumber()){
      return PathAux._subPath(p.getCBar(),pLong.getCBar());
      }
    boolean isP1=p.outerNumber()<pLong.outerNumber();
    while(true){
      if(isP1){pLong=this._reducePath(pLong);}
      else{p=this._reducePath(p);}
      if(p==null || pLong==null){return null;}
      if(p.outerNumber()==pLong.outerNumber()){
        return PathAux._subPath(p.getCBar(),pLong.getCBar());
        }
      }
    }
  default boolean equiv(Ast.Type t, Ast.Type t1){
    return t.getMdf()==t1.getMdf() && equiv(t.getPath(),t1.getPath());
    }

  default ExpCore.ClassB get(int n){
    assert n>=0;
    if(n==0){return this.top();}
    else return this.pop().get(n-1);
    }

  default Program push(Ast.C c) {
    CtxL splitted=CtxL.split(this.top(), c);
    ExpCore holeP = splitted.originalHole();
    assert holeP instanceof ClassB;
    return new PushedProgram((ClassB)holeP,splitted,this);
    }

  /*mah -push(L)//non determinism is not relevant if update is not used
  p.push(L)=p.push(ctxL,L)//an evilPush can exist in implementation
  with ctxL[L]=p.top()
  //with p'=p.evilPush(L)   p'.top()==L, p'.pop()==p, p'.update(..) error!
  */

  default Program navigate(List<Ast.C>cs){
    Program res=this;
    for(Ast.C c:cs){res=res.push(c);}
    return res;
    }

  default Program navigate(Ast.Path p){
    Program res=this;
    for(int i=0;i<p.outerNumber();i++){res=res.pop();}
    return res.navigate(p.getCBar());
  }
  default ExpCore.ClassB extractClassB(Ast.Path p){
    if (p.equals(Path.Any())) {
      return ClassB.Any; }
    else if (p.equals(Path.Void())) {
      return ClassB.Void; }
    else if (p.equals(Path.Library())) {
      return ClassB.Library; }

    Program res1=this;
    for(int i=0;i<p.outerNumber();i++){res1=res1.pop();}
    ExpCore.ClassB top=res1.top();
    try{return top.getClassB(p.getCBar());}
    catch(ErrorMessage.PathMetaOrNonExistant pne){
      throw pne.withListOfNodeNames(p.getCBar()).withCb(top);
      }
    }
  default PData reprAsPData(){
    PData res=new PData(this);
    return res;
    }
  static Program emptyLibraryProgram(){
    return emptyLibraryProgram(10);
    }
  static Program emptyLibraryProgram(int freshIdStart){
    FlatProgram res= new FlatProgram(EmptyProgramHolder.cached);
    res.freshIds=new int[]{freshIdStart};
    return res;
    }
  /**should be always valid for normalized tops.
   * Returns true or error*/
  default boolean checkTopInterfacesDefined() {
    for(Path pi:this.top().getSuperPaths()) {
      this.navigate(pi);
      }
    return true;
    }
  }
class EmptyProgramHolder{
  static final ClassB cached=new ClassB(Doc.empty(), false,Collections.emptyList(),Collections.emptyList(), Position.noInfo, Phase.Typed, -2);
  }

class FlatProgram extends Methods{
  int[] freshIds=null;//In this way I create a cell that can be shared on FlatProgram.updateTop
  ExpCore.ClassB l;
  FlatProgram(ExpCore.ClassB l){
    this.l=l;
    }

  public Program pop() {
    throw new Program.EmptyProgram();}

  public Program push(CtxL ctx, ClassB l) {
    return new PushedProgram(l,ctx,this);
    }

  public ClassB top() {return l;}

  public Program updateTop(ClassB l) {
    FlatProgram fp= new FlatProgram(l);
    fp.freshIds=this.freshIds;
    return fp;
    }

  public Path _reducePath(Path p){return null;}

  public boolean equiv(Path p, Path p1) {return p.equals(p1);}

  public Program growFellow(Program fellow) {throw new Program.EmptyProgram();}

  public int getFreshId(){
    return freshIds[0]++;
    }

  public List<Object> exploredWay() {
    return new ArrayList<>();
    }
  }
class PushedProgram extends Methods{
  ClassB newTop;
  CtxL splitPoint;
  Program former;
  public PushedProgram(ClassB newTop, CtxL splitPoint, Program former) {
    assert newTop!=null:
      "";
    assert former!=null:
      "";
    this.newTop=newTop;
    this.splitPoint=splitPoint;
    this.former=former;
    assert (!this.getClass().equals(PushedProgram.class)) || splitPoint.fillHole(newTop).equals(former.top()):
    "";
  }
  public Program pop() { return former;}

  public Program push(CtxL ctx, ClassB l) {
    return new PushedProgram(l,ctx,this);
    }

  public ClassB top() {return newTop;}

  public Program updateTop(ClassB l) {return new UpdatedProgram(l,this.splitPoint,this.former);}

  public Path _reducePath(Path p){
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
    List<Ast.C> cs = p.getCBar();
    if(cs.isEmpty()){return null;}
    ClassB.Member m=this.splitPoint.originalCtxM();//This1.C.Cs
    if(!(m instanceof ClassB.NestedClass)){return null;}
    ClassB.NestedClass nc=(ClassB.NestedClass)m;
    Ast.C ncName=nc.getName();
    if(!ncName.equals(cs.get(0))){return null;}
    if(!IsCompiled.of(nc.getE())) {return null;}//Added line 2/8/2018
    //here we are sure that ctxL={..C:ctxC[]..}
    //and that the original hole content was compiled (LC is required in the formalism).
    //we do not require C:[]
    //if(!(nc.getE() instanceof ClassB)){return null;}//requiring C:[] would not cause an issue on 17/10/2018
    return Path.outer(0, cs.subList(1, cs.size()));
    }

  public Program growFellow(Program fellow) {
    CtxL ctx=this.splitPoint.divide(fellow.top());
    return fellow.push(ctx,(ClassB)ctx.originalHole());
    //(L,ctxL,_).growFellow(p)==p.push(p.top()/ctxL)
    }
  public int getFreshId(){
    int popped=this.pop().getFreshId();
    return popped;//+"."+this.splitPoint.nameWhereThereisTheHole();
    }
  public List<Object> exploredWay() {
    List<Object> sup=this.former.exploredWay();
    sup.add(this.splitPoint.nameOfWayInside());
    return sup;
  }
  }
class UpdatedProgram extends PushedProgram{
  public UpdatedProgram(ClassB newTop, CtxL splitPoint, Program former) {
    super(newTop, splitPoint, former);}

  public Program pop() {
    return former.updateTop(splitPoint.fillHole(newTop));
    }
  }

class EvilPushed extends Methods{
  ClassB newTop; Program former;
  public EvilPushed(ClassB newTop, Program former) {
    assert newTop!=null:
      "";
    assert former!=null:
      "";
    this.newTop=newTop; this.former=former;
    }

  public Program pop() {return former;}
  //TODO: may be next line need to not throw, if allowed, then updateTop need to check if there is an evil in the tail, and throw on update
  public Program push(CtxL ctx, ClassB l) {throw Assertions.codeNotReachable();}

  public ClassB top() {return newTop;}

  public Program updateTop(ClassB l) {return new EvilPushed(l,former);}

  public Path _reducePath(Path p) {
    if(p.tryOuterNumber()>1){
      Path p1=p.setNewOuter(p.outerNumber()-1);
      Path p2=this.pop()._reducePath(p1);
      if(p2==null){return null;}
      return p2.setNewOuter(p2.outerNumber()+1);
      }
    return null;
  }
  public Program growFellow(Program fellow) {throw Assertions.codeNotReachable();}

  public int getFreshId(){
    int popped=this.pop().getFreshId();
    return popped;//+".<EvilPushed>";
    }

  public List<Object> exploredWay() {
    List<Object>sup=this.former.exploredWay();
    sup.add(null);
    return sup;
  }
  }