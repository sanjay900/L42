package is.L42.connected.withSafeOperators.refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import coreVisitors.CloneVisitorWithProgram;
import coreVisitors.CloneWithPath;
import coreVisitors.From;
import coreVisitors.FromInClass;
import is.L42.connected.withSafeOperators.ExtractInfo;
import is.L42.connected.withSafeOperators.ExtractInfo.ClassKind;
import is.L42.connected.withSafeOperators.location.Method;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.ClassUnfit;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.IncoherentMapping;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.MethodClash;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.PathUnfit;
import tools.Assertions;
import tools.Map;
import ast.Ast;
import ast.ErrorMessage;
import ast.ExpCore;
import ast.ExpCore.*;
import ast.Ast.Type;
import ast.Ast.C;
import ast.Ast.Doc;
import ast.Ast.Path;
import ast.Ast.Position;
import ast.Ast.Stage;
import ast.Ast.Type;
import ast.ExpCore.ClassB;
import ast.ExpCore.ClassB.Member;
import ast.ExpCore.ClassB.MethodWithType;
import ast.ExpCore.ClassB.NestedClass;

import ast.Util.CsPz;
import ast.Util.CsPath;
import ast.Util.CsMwtPMwt;
import auxiliaryGrammar.Functions;
import programReduction.Program;
public class RedirectObj {

private List<CsPath> verified;
  private ClassB top;
  public RedirectObj(ClassB cb){top=cb;}

  public ClassB redirect(Program p, List<Ast.C> internal,Path external) throws ClassUnfit, IncoherentMapping, MethodClash, PathUnfit{
    //call redirectOk, if that is ok, no other errors?
    //should cb be normalized first?
    if (external.isCore()) external = external.setNewOuter(external.outerNumber()+1);
    assert external.isPrimitive() || external.outerNumber()>0;

    p=p.evilPush(top);
    redirectOk(p,internal,external);
    return Redirect.applyRedirect(p, new PathMap(verified));
  }

  public void redirectOk(Program p,List<Ast.C> internal,Path external) throws ClassUnfit, IncoherentMapping, MethodClash, PathUnfit{
    verified=new ArrayList<>();
    List<CsPz> ambiguities=new ArrayList<>();
    List<CsMwtPMwt> exceptions=new ArrayList<>();
    ambiguities.add(new CsPz(internal,new HashSet<>(Arrays.asList(external))));
    for(CsPz current=choseUnabigus(ambiguities); current!=null;current=choseUnabigus(ambiguities)){
      CsPz _current=current;//closure final limitations
      assert ambiguitiesOk(ambiguities);
      assert verified.stream().allMatch(pp->!pp.getCs().equals(_current.getCs())):
        verified+" "+_current;
      redirectOkAux(p,current,ambiguities,exceptions);
      assert current.getPathsSet().size()==1;
      assert verified.stream().allMatch(pp->!pp.getCs().equals(_current.getCs())):
        verified+" "+_current.getCs();
      verified.add(new CsPath(current.getCs(),current.getPathsSet().iterator().next()));
      accumulateVerified(ambiguities);
    }
    assert choseUnabigus(ambiguities)==null;
    if(!ambiguities.isEmpty()){
      throw new RefactorErrors.IncoherentMapping().msgMapping(verified, ambiguities,null,Collections.emptyList());
      }
    checkExceptionOk(p,exceptions);
    return;
    }
  private boolean ambiguitiesOk(List<CsPz> ambiguities) {
    return ambiguities.stream().allMatch(e1->ambiguities.stream().allMatch(e2->(e1==e2|| !e1.getCs().equals(e2.getCs()))));
  }
  private void checkExceptionOk(Program p,List<CsMwtPMwt> exceptions) throws MethodClash {
    for(CsMwtPMwt exc:exceptions){
     List<Path> src = Map.of(t->traspose(t.getPath()), exc.getMwt1().getMt().getExceptions());
     //was: src=Map.of(pi->traspose(verified,pi),src); and now is merged on top
     List<Path>other=Map.of(t->t.getPath(),exc.getMwt2().getMt().getExceptions());
     if(!src.containsAll(other)){
       Method m1=Method.of(exc.getMwt1(),top,exc.getSrc1());
       Method m2=Method.of(exc.getMwt2(),p,exc.getSrc2());
       throw new RefactorErrors.MethodClash(m1,m2).msg("Issues:  Incompatible exceptions ");
       //throw Errors42.errorMethodClash(exc.getSrc().getCBar(), exc.getMwt1(),exc.getMwt2(),true,
       //    Collections.emptyList(),false,false,false);
       }
    }
  }
  private Path traspose(Path pi) {
    if (pi.isPrimitive()){return pi;}
    if(pi.outerNumber()>0){return pi;}
    CsPath selectPP = selectPP(verified,pi.getCBar());
    assert selectPP!=null:verified+"  "+pi;
    pi=selectPP.getPath();
    return pi;
  }
  /*private static void lessEqual(List<PathSPath> ambiguities) {
    Iterator<PathSPath> it = ambiguities.iterator();
    while(it.hasNext()){
      Path pi=it.next().getPath();
      for(PathPath pp:verified){if(pp.getPath1().equals(pi)){it.remove();}}
    }
  }*/
  private void accumulateVerified(List<CsPz> ambiguities) throws IncoherentMapping {
    assert ambiguitiesOk(ambiguities);
    for(CsPath pp:verified){
      CsPz psp=selectPSP(ambiguities,pp.getCs());
      if(psp==null){continue;}
      //ambiguities.add(new PathSPath(pp.getPath1(),Arrays.asList(pp.getPath2())));
      if(psp.getPathsSet().contains(pp.getPath())){ambiguities.remove(psp);}
      else{
        List<Path> ps=new ArrayList<>(psp.getPathsSet());
        ps.add(pp.getPath());
        throw new RefactorErrors.IncoherentMapping().msgMapping(verified, ambiguities,psp.getCs(),ps);
        }
    }
  }
  private CsPz selectPSP(List<CsPz> set,List<Ast.C> key){
    for(CsPz elem:set){if(elem.getCs().equals(key)){return elem;}}
    return null;
  }
  private CsPath selectPP(List<CsPath> set,List<Ast.C> key){
    for(CsPath elem:set){if(elem.getCs().equals(key)){return elem;}}
    return null;
  }
  private void redirectOkAux(Program p, CsPz current, List<CsPz> ambiguities, List<CsMwtPMwt> exceptions) throws ClassUnfit, IncoherentMapping, MethodClash, PathUnfit {
    assert current.getPathsSet().size()==1;
    List<Ast.C> cs=current.getCs();
    if(cs.isEmpty() || MembersUtils.isPrivate(cs)){
      throw new RefactorErrors.PathUnfit(cs).msg("Private path");
      }
    if(!MembersUtils.isPathDefined(top,cs)){
      throw new RefactorErrors.PathUnfit(cs).msg("Non existant path");
      }
    ClassB currentIntCb=top.getClassB(cs);
    //path exists by construction.
    Path path=current.getPathsSet().iterator().next();
    ClassB currentExtCb = p.extractClassB(path);
    assert path.tryOuterNumber() != 0;
    assert cs.stream().allMatch(c->!c.isUnique());
    boolean isPrivateState=ExtractInfo.hasPrivateState(currentIntCb);
    boolean isNoImplementation=ExtractInfo.isNoImplementation(currentIntCb);
    boolean headerOk=currentIntCb.isInterface()==currentExtCb.isInterface();
    ClassKind kindSrc= ExtractInfo.classKind(top,cs,currentIntCb, null, isPrivateState, isNoImplementation);
    if(!headerOk && !currentIntCb.isInterface()){
      if(kindSrc==ClassKind.FreeTemplate){headerOk=true;}
    }
    ClassKind kindDest = ExtractInfo.classKind(null,null,currentExtCb,null,null,null);
    if(isPrivateState || !isNoImplementation){//unexpectedMembers stay empty if there is implementation
      assert kindSrc!=ClassKind.FreeTemplate
          && kindSrc!=ClassKind.Template
          && kindSrc!=ClassKind.Interface:
            kindSrc;
      //TODO: code up can be cleaned to remove extra ExtractInfo checks
      throw new RefactorErrors.ClassUnfit().msgRedirectTemplate(current.getCs(), path, currentExtCb.isInterface());
      //throw Errors42.errorSourceUnfit(current.getPath().getCBar(),path,
      //  kindSrc,kindDest,Collections.emptyList(), headerOk, Collections.emptyList());
    }
    redirectOkImpl(kindSrc,kindDest,ambiguities,current,currentIntCb,currentExtCb);
    List<Member> unexpectedMembers=new ArrayList<>();
    for(Member mi:currentIntCb.getMs()){
      Optional<Member> miPrime = Functions.getIfInDom(currentExtCb.getMs(),mi);
      if(miPrime.isPresent() && miPrime.get().getClass().equals(mi.getClass())){
        Member miGet=miPrime.get();
        redirectOkMember(p,ambiguities,exceptions, mi,path,miGet,current);
      }
      else{unexpectedMembers.add(mi);}
    }
    if(unexpectedMembers.isEmpty() && headerOk){return;}
    throw new RefactorErrors.ClassUnfit().msgRedirectUnexpectedM(cs, path, unexpectedMembers);
    //throw Errors42.errorSourceUnfit(cs,path,
    //    kindSrc,kindDest,unexpectedMembers, headerOk, Collections.emptyList());

  }
  private void redirectOkMember(Program p,List<CsPz> ambiguities,List<CsMwtPMwt>exceptions, Member mi, Path pathExt, Member miGet, CsPz current) throws IncoherentMapping, MethodClash {
    if(mi instanceof NestedClass){
      assert miGet instanceof NestedClass;
      assert ((NestedClass)mi).getName().equals(((NestedClass)miGet).getName());
      List<Ast.C> src=new ArrayList<>(current.getCs());
      src.add(((NestedClass)mi).getName());
      Path dest=current.getPathsSet().iterator().next().pushC(((NestedClass)mi).getName());
      plusEqual(ambiguities,src,Arrays.asList(dest));
      return;
    }
    assert mi.getClass().equals( miGet.getClass());
    assert mi instanceof MethodWithType:mi;
    MethodWithType mwtSrc=(MethodWithType)mi;
    MethodWithType mwtDest=(MethodWithType)miGet;
    mwtSrc=From.from(mwtSrc, Path.outer(0,current.getCs()));//this is what happens in p.method
    mwtDest=From.from(mwtDest, current.getPathsSet().iterator().next());
    assert mwtSrc.getMs().equals(mwtDest.getMs());
    boolean thisMdfOk=mwtSrc.getMt().getMdf().equals(mwtDest.getMt().getMdf());
    boolean retOk=redirectOkT(ambiguities,mwtSrc.getMt().getReturnType(),mwtDest.getMt().getReturnType());
    List<Integer>  parWrong=new ArrayList<Integer>();
    {int i=-1;for(Type tSrc:mwtSrc.getMt().getTs()){i+=1;Type tDest=mwtDest.getMt().getTs().get(i);
      if(!redirectOkT(ambiguities,tSrc,tDest)){parWrong.add(i);};
    }}
    boolean excOk=plusEqualAndExc(ambiguities,exceptions,current.getCs(),mwtSrc,pathExt, mwtDest);
    if(thisMdfOk && retOk && excOk && parWrong.isEmpty()){return;}
    Method m1=Method.of(mwtSrc,top,current.getCs());
    Method m2=Method.of(mwtDest,p,pathExt);
    throw new RefactorErrors.MethodClash(m1,m2).msg("Issues:"+(thisMdfOk?"":" This modifier ")+(retOk?"":" Return type")+(excOk?"":" Incompatible exceptions ")+(parWrong.isEmpty()?"":" wrong parameters "));
    //throw Errors42.errorMethodClash(current.getPath().getCBar(),mwtSrc,mwtDest,excOk,parWrong,retOk, thisMdfOk,false);
    }
  private boolean plusEqualAndExc(List<CsPz> ambiguities, List<CsMwtPMwt> exceptions, List<Ast.C> src,MethodWithType mwtSrc,Path pathDest, MethodWithType mwtDest) throws IncoherentMapping {
    //int countExternal=0;
    //int countExternalSatisfied=0;
    List<Path> srcExc = Map.of(t->t.getPath(),mwtSrc.getMt().getExceptions());
    List<Path> destExc = Map.of(t->t.getPath(),mwtDest.getMt().getExceptions());
    exceptions.add(new CsMwtPMwt(src,mwtSrc,pathDest,mwtDest));
    for(Path pi:srcExc){
      if(pi.isPrimitive() || pi.outerNumber()>0){
        //countExternal+=1;
        //if(destExc.contains(pi)){countExternalSatisfied+=1;}
        continue;}
      if (!destExc.isEmpty())
        plusEqual(ambiguities,pi.getCBar(),destExc);
    }
    //int countInternal=srcExc.size()-countExternal;
    //return countInternal+countExternalSatisfied>=destExc.size();
    return true;//we think the former line could never made a difference
  }
  private boolean redirectOkT(List<CsPz> ambiguities, Type tSrc, Type tDest) throws IncoherentMapping {
    if(!tSrc.getClass().equals(tDest.getClass())){
      return false;
      }//incompatible internal/external types t1 t2
    //Boolean[] pathOk={true};

    Type ntP=(Type)tDest;
    if(!tSrc.getMdf().equals(ntP.getMdf())){return false;}//incompatible internal/external types t1 t2
    return plusEqualCheckExt(ambiguities,tSrc.getPath(),Arrays.asList(ntP.getPath()));
    }
  private boolean plusEqualCheckExt(List<CsPz> ambiguities, Path path, List<Path> paths) throws IncoherentMapping {
    if(!path.isPrimitive() && path.outerNumber()==0){
      plusEqual(ambiguities,path.getCBar(),paths);
      assert ambiguitiesOk(ambiguities);
      return true;
      }
    assert paths.size()==1;
    return path.equals(paths.get(0));
  }
  private void redirectOkImpl(ClassKind kindSrc,ClassKind kindDest,List<CsPz> ambiguities, CsPz current, ClassB currentIntCb, ClassB currentExtCb) throws ClassUnfit, IncoherentMapping {
   // List<Path>unexpectedInterfaces=new ArrayList<>(unexpectedI);
   // Collections.sort(unexpectedInterfaces,(pa,pb)->pa.toString().compareTo(pb.toString()));
    List<Path>extPs=currentExtCb.getSuperPaths();
    Path destP=current.getPathsSet().iterator().next();
    extPs=Map.of(pi->From.fromP(pi,destP), extPs);
    List<Path> unexpectedInterfaces=new ArrayList<>();
    for(Path pi:currentIntCb.getSuperPaths()){
      Path pif=From.fromP(pi, Path.outer(0,current.getCs()));
      if(extPs.isEmpty()){unexpectedInterfaces.add(pif);}
      else if(pif.isPrimitive() || pif.outerNumber()>0){
        if(!extPs.contains(pif)){
          unexpectedInterfaces.add(pif);
          }
      }
      else{
        plusEqual(ambiguities,pif.getCBar(),extPs);
      }
    }
    if(unexpectedInterfaces.isEmpty()){return;}
    throw new RefactorErrors.ClassUnfit().msgRedirectUnexpectedI(current.getCs(), current.getPathsSet().iterator().next(), unexpectedInterfaces);
    //throw Errors42.errorSourceUnfit(current.getPath().getCBar(),current.getPathsSet().iterator().next(),
    //      kindSrc,kindDest,Collections.emptyList(), true, unexpectedInterfaces);
  }

  private void plusEqual(List<CsPz> ambiguities, List<Ast.C> pif, List<Path> extPs) throws IncoherentMapping {
    assert ambiguitiesOk(ambiguities);
    try{assert !extPs.isEmpty();
    assert !extPs.contains(null);
    for(CsPz psp:ambiguities){
      if(psp.getCs().equals(pif)){
        psp.setPathsSet(new HashSet<>(psp.getPathsSet()));
        assert !psp.getPathsSet().isEmpty();
        Path forErr=psp.getPathsSet().iterator().next();
        psp.getPathsSet().retainAll(extPs);
        if(psp.getPathsSet().isEmpty()){
          List<Path>psErr=Arrays.asList(forErr,extPs.get(0));
          throw new RefactorErrors.IncoherentMapping().msgMapping(verified,ambiguities,psp.getCs(),psErr);
          }
        return;
      }}
    ambiguities.add(new CsPz(pif,new HashSet<>(extPs)));
  }finally{assert ambiguitiesOk(ambiguities);}}
  private CsPz choseUnabigus(List<CsPz> ambiguities){
    for(CsPz psp:ambiguities){if (psp.getPathsSet().size()==1){return psp;}}
    return null;
  }
  /*
  public static List<PathPath> redirectOk(Program p,ClassB l, Path csPath,Path path){
    List<PathPath>setVisited=new ArrayList<>();
    redirectOk(setVisited,p,l,csPath,path);
    return setVisited;
  }
  public static void redirectOk(List<PathPath>setVisited,Program p,ClassB l, Path csPath,Path path){
    PathPath currentPP=new PathPath(csPath,path);
    if(setVisited.contains(currentPP)){return;}
    setVisited.add(currentPP);
    Errors42.checkCoherentMapping(setVisited);
    List<String>cs=csPath.getCBar();
    if(cs.isEmpty()){throw Errors42.errorInvalidOnTopLevel();}
    Errors42.checkExistsPathMethod(l, cs, Optional.empty());
    Boolean[] csPrivate=new Boolean[]{false};
    ClassB l0NoFrom=Program.extractCBar(cs,l,csPrivate);//L(Cs)[from Cs]=L0={H M0 ... Mn}//No, from does not work here
    //path exists by construction.
    ClassB l0DestNoFrom;
    if(path.isCore()){
      assert path.outerNumber()>0:
        path;
      l0DestNoFrom= p.extractCb(path);
      }//p(Path)[from Path]=L0'={H' M0' ... Mn', _}//reordering of Ms allowed here
    else{
      assert path.isPrimitive();
      l0DestNoFrom=new ClassB(Doc.empty(),Doc.empty(),path.equals(Path.Any()),Collections.emptyList(),Collections.emptyList());
    }
    //(a)Cs is public in L, and Cs have no private state;
    boolean isPrivate=csPrivate[0];
    boolean isPrivateState=ExtractInfo.hasPrivateState(l0NoFrom);
    //all its methods have no implementation, that is:
    //for all Mi,i=0..n: Mi is of form h or Mi is of form C:_
   boolean isNoImplementation=ExtractInfo.isNoImplementation(l0NoFrom);
    //(b) L[H=~H'] holds
    boolean headerOk=l0NoFrom.isInterface()==l0DestNoFrom.isInterface();
    ClassKind kindSrc=null;
    if(!headerOk && !l0NoFrom.isInterface()){
      kindSrc=ExtractInfo.classKind(l,cs,l0NoFrom,null,isPrivateState, isNoImplementation);
      if(kindSrc==ClassKind.FreeTemplate){headerOk=true;}
    }
    //(c) S,Cs->Path;p|-L[Paths=~Paths']:S'
    //(d) S;p|-L[M0=~M0' Cs->Path]:S0 ... S;p|-L[Mn=~Mn' Cs->Path]:Sn
    //(e) S'=Cs->Path,S0..Sn
    if(!isNoImplementation){//unexpectedMembers stay empty if there is implementation
      if(kindSrc==null){kindSrc = ExtractInfo.classKind(l,cs,l0NoFrom, null, isPrivateState, isNoImplementation);}
      ClassKind kindDest = ExtractInfo.classKind(null,null,l0DestNoFrom,null,null,null);
      assert kindSrc!=ClassKind.FreeTemplate
          || kindSrc!=ClassKind.Template
          || kindSrc!=ClassKind.Interface:
            kindSrc;
      throw Errors42.errorSourceUnfit(currentPP.getPath1().getCBar(),path,
        kindSrc,kindDest,Collections.emptyList(), headerOk, Collections.emptyList(), isPrivate);
    }
    Set<Path>unexpectedI=redirectOkImpl(setVisited,currentPP,p,l,
        Map.of(pi->From.fromP(pi,csPath), l0NoFrom.getSupertypes()),
        Map.of(pi->From.fromP(pi,path),l0DestNoFrom.getSupertypes()));
    List<Path>unexpectedInterfaces=new ArrayList<>(unexpectedI);
    Collections.sort(unexpectedInterfaces,(pa,pb)->pa.toString().compareTo(pb.toString()));
    List<Member> unexpectedMembers=new ArrayList<>();
    for(Member mi:l0NoFrom.getMs()){
      Optional<Member> miPrime = Program.getIfInDom(l0DestNoFrom.getMs(),mi);
      if(miPrime.isPresent() && miPrime.get().getClass().equals(mi.getClass())){
        Member miGet=miPrime.get();
        if(miGet instanceof MethodWithType){
          MethodWithType mwt=(MethodWithType)miGet;
          mwt=From.from(mwt, path);//this is what happens in p.method
          //mwt=Norm.of(p,mwt,true);
          miGet=mwt;
        }
          redirectOk(setVisited,p,l,From.from(mi,csPath),miGet,currentPP);
      }
      else{unexpectedMembers.add(mi);}
    }
    boolean isOk=true;
    if(!unexpectedMembers.isEmpty()){isOk=false;}
    if(!unexpectedI.isEmpty()){isOk=false;}
    if(!headerOk){isOk=false;}
    if(isPrivate){isOk=false;}
    if(isOk){return;}
    if(kindSrc==null){kindSrc = ExtractInfo.classKind(l,cs,l0NoFrom, null, isPrivateState, isNoImplementation);}
    ClassKind kindDest = ExtractInfo.classKind(null,null,l0DestNoFrom,null,null,null);
    throw Errors42.errorSourceUnfit(currentPP.getPath1().getCBar(),path,
        kindSrc,kindDest,unexpectedMembers, headerOk, unexpectedInterfaces, isPrivate);
  }

  private static Set<Path> redirectOkImpl(List<PathPath> s, PathPath currentPP, Program p, ClassB l, List<Path> paths, List<Path> pathsPrime) {
    //(paths ok)//and I can not use it for exceptions since opposite subset relation
    //S;p|-L[Paths=~Paths']:S'
    //Path subsetof Path'
    //or Paths=Path, Paths'=Path' and S;p|-L[Path=~Path']:S'
    if(paths.isEmpty()){return Collections.emptySet();}
    Set<Path> ps=new HashSet<>(paths);
    Set<Path> psPrime=new HashSet<>(pathsPrime);
    ps.removeAll(pathsPrime);
    psPrime.removeAll(paths);
    if(ps.isEmpty()){return Collections.emptySet();}
    if(ps.size()!=1){return ps;}
    if(psPrime.size()!=1){return ps;}
    boolean pathOk=redirectOkPath(s, p, l,ps.iterator().next(),psPrime.iterator().next());
    if(pathOk){return Collections.emptySet();}
    return ps;
    }
  public static void redirectOk(List<PathPath> s, Program p, ClassB l, Member mi, Member miPrime, PathPath currentPP) {
    //from before I know the members mi, miPrime are of the same class.
    mi.match(
      nc->redirectOkNc(s,p,l,nc,(NestedClass)miPrime,currentPP),
      errMi->{
        throw Assertions.codeNotReachable("Should be catched before as in fully abstract source");
        },
      mt->redirectOkMt(s,p,l,mt,(MethodWithType)miPrime,currentPP));
  }
  private static Void redirectOkMt(List<PathPath> s, Program p, ClassB l, MethodWithType mt, MethodWithType mtPrime, PathPath currentPP) {
    boolean isMdfOk=mt.getMt().getMdf()==mtPrime.getMt().getMdf();
    boolean isRetTypeOk=redirectOkType(s,p,l,mt.getMt().getReturnType(),mtPrime.getMt().getReturnType());
    List<Integer> wrongTypes=new ArrayList<>();
    for(int i=0;i<mt.getMt().getTs().size();i+=1){
      boolean isOkType=redirectOkType(s,p,l,mt.getMt().getTs().get(i),mtPrime.getMt().getTs().get(i));
      if(!isOkType){wrongTypes.add(i);}
    }
    Set<Path> badExc=redirectOkExceptions(s,p,l,mt.getMt().getExceptions(),mtPrime.getMt().getExceptions());
    if(!badExc.isEmpty() || !wrongTypes.isEmpty()|| !isRetTypeOk ||!isMdfOk){
      throw Errors42.errorMethodClash(currentPP.getPath1().getCBar(),mt,mtPrime, badExc.isEmpty(), wrongTypes, isRetTypeOk, isMdfOk);
    }
    return null;
  }
  private static Set<Path> redirectOkExceptions(List<PathPath> s, Program p, ClassB l, List<Path> exceptions, List<Path> exceptionsPrime) {
    if(exceptionsPrime.isEmpty()){return Collections.emptySet();}
    Set<Path> exc=new HashSet<>(exceptions);
    Set<Path> excPrime=new HashSet<>(exceptionsPrime);
    excPrime.removeAll(exceptions);
    if(excPrime.isEmpty()){return  Collections.emptySet();}
    exc.removeAll(exceptionsPrime);
    if(exc.size()!=1){return exc;}
    if(excPrime.size()!=1){return exc;}//ok not excPrime
    boolean pathOk=redirectOkPath(s, p, l, exc.iterator().next(),exceptionsPrime.iterator().next());
    if(pathOk){ return Collections.emptySet();}
    return exc;
  }
  private static boolean redirectOkType(List<PathPath> s, Program p, ClassB l, NormType t, NormType tPrime) {
    if(!t.getClass().equals(tPrime.getClass())){return false;}//incompatible internal/external types t1 t2
    Boolean[] pathOk={true};
    t.match(
      normType->{
        NormType ntP=(NormType)tPrime;
        if(!normType.getMdf().equals(ntP.getMdf())){return false;}//incompatible internal/external types t1 t2
        if(!normType.getPh().equals(ntP.getPh())){return false;}//incompatible internal/external types t1 t2
        pathOk[0]=redirectOkPath(s,p,l,normType.getPath(),ntP.getPath());
        return null;
      },
      hType->{
        HistoricType htP=(HistoricType)tPrime;
        if(!hType.getSelectors().equals(htP.getSelectors())){return false;}//incompatible internal/external types t1 t2
        if(hType.isForcePlaceholder()!=htP.isForcePlaceholder()){return false;}//incompatible internal/external types t1 t2
        pathOk[0]=redirectOkPath(s,p,l,hType.getPath(),htP.getPath());
        return null;
      });
    return pathOk[0];
  }
  private static boolean redirectOkPath(List<PathPath> s, Program p, ClassB l,Path cs, Path path) {
    //S;p|-L[Outern.Cs =~Outern.Cs]:emptyset  holds with n>0
    if(cs.isPrimitive() ||cs.outerNumber()>0){
      if(!cs.equals(path)){return false;}
      return true;
    }
    //otherwise
    //S;p|-L[This0.Cs =~ Path ]: S'
    //if S;p|-L[redirect Cs->Path]:S'
    redirectOk(s,p,l,cs,path);
    return true;
  }
  private static Void redirectOkNc(List<PathPath> s, Program p, ClassB l, NestedClass nc, ClassB.NestedClass miPrime, PathPath currentPP) {
    //S;p|-L[C:L1=~C:L1' Cs->Path]:S'
    //if S,Cs->Path;p|-L[redirect Cs.C->Path.C]:S'
    Path src=currentPP.getPath1().pushC(nc.getName());
    Path dest=currentPP.getPath2().pushC(nc.getName());
    redirectOk(s,p,l,src,dest);
    return null;
  }
*/
}