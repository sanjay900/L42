package newTypeSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ast.ExpCore;
import ast.Ast;
import ast.Ast.Doc;
import ast.Ast.Mdf;
import ast.Ast.Type;
import ast.ErrorMessage;
import ast.ErrorMessage.PosImprove;
import ast.Ast.Path;
import ast.Ast.Position;
import ast.Ast.SignalKind;
import ast.ExpCore.Block;
import ast.ExpCore.Block.Dec;
import ast.ExpCore.Block.On;
import ast.ExpCore.ClassB.MethodWithType;
import coreVisitors.FreeVariables;
import programReduction.Norm;
import tools.Assertions;
import tools.Map;

public interface TsBlock extends TypeSystem{
  default TOut tsBlock(TIn in, Block s) {
    TOut res1;try{res1=tsBlockBase(in,s);}
    catch(ErrorMessage err){
      if(err instanceof PosImprove){
      PosImprove pi=(PosImprove)err;
      err=(ErrorMessage)pi.improvePos(s.getP());
      }
      throw err;
      }
    if (res1.isOk()){return res1;}
    if (!promotionMakesSense(in,res1.toError())){return res1;}//promotionMakesSense: mut that need capsule
    TOut res2=tsBlockPromotion(in,s);//calls tsBlock internally,
    //thanks to promotionMakesSense does not goes in loop
    if (res2.isOk()){return res2;}
    //if we are here, both res1,res2 not ok
    return combine(res1.toError(),res2.toError());
    }

  default int splitDs(TIn in,List<Block.Dec> ds){
    int i=0;
    final int n=ds.size()-1;
    if (ds.isEmpty()){return 0;}
    List<String> xs=new ArrayList<>();
    while(true){
      xs.addAll(coreVisitors.FreeVariables.of(ds.get(i).getInner()));//xs U  FV(ei)
      if (xsNotInDomi(xs,ds,i+1)){return i;}
      //cut will be from 0 to i included
      if (i==n){return i;} //ds.size-1
      i+=1;
      }
    }
default boolean xsNotInDomi(List<String> xs,List<Dec> ds,int ip1){
  //ds=ds0..dsn;
  //domi=dom(dsi+1..dsn)
  //domi\xs=domi == no x in xs in dom(dsi+1..dsn)
  if(ip1>=ds.size()){return true;}
  String xDsip1=ds.get(ip1).getX();
  if(xs.contains(xDsip1)){return false;}
  return xsNotInDomi(xs,ds,ip1+1);
  }

  default TOut tsBlockBase(TIn in,Block s){
   List<Block.Dec> ds=StaticDispatch.of(in.p, in,s.getDecs(),s.getP(),true);
   s=s.withDecs(ds);
   List<Block.On> ks=s.getOns();
   TIn in1=in.removeGDs(ds);//G'=G/dom(ds)
   TIn in2=in1.gKs(ks);//G'[ks]
   //Phase| p| G'[ks] |- ds ~> ds' |Tr' | G0
   TOutDs _dsOut=dsType(in2,ds);
   if(!_dsOut.isOk()){
     TErr err=_dsOut.toError();
     if(!err.kind.needContext){return err;}
     //TODO: here we have the info to capture a failure about ds and discover if
     //extant name (fwd[%]* x) was hidden by error safety or  modifiable name (capsule/mut/lent x)
     //was locked by error safety[cite the line number of the catch]
     return err;
     }
   TOkDs dsOk=_dsOut.toOkDs();
   //Phase| p| G'| Tr' |- ks~> ks' : Ts <= T' | Tr
   TOutKs _ksOut=ksType(in1,dsOk.trAcc,ks);
   if(!_ksOut.isOk()){return _ksOut.toError();}
   TOkKs ksOk=_ksOut.toOkKs();
   ks=ksOk.ks;//now resolved
   //Phase| p| G'[G0\dom(G')] |- e0~>e'0:T0 <=T' | Tr0
   TInG G0LessG1=dsOk.g.removeGXs(in1.g.keySet());
   TOut _e0Out=type(in1.addGG(G0LessG1).withE(s.getE(), in.expected));
   if(!_e0Out.isOk()){return _e0Out.toError();}
   TOk e0Ok=_e0Out.toOk();
   //T= mostGeneralMdf({T0.mdf,Ts.mdfs}) T'.P //set of Mdfs admits no single most general mdf
   Set<Mdf>mdfs=new HashSet<>();
   for(Type nt:ksOk.ts){
     mdfs.add(nt.getMdf());
     }
   mdfs.add(e0Ok.computed.getMdf());
   Mdf tMdf=TypeManipulation._mostGeneralMdf(mdfs);
   if(tMdf==null){
     return new TErr(in,"",e0Ok.computed,ErrorKind.NoMostGeneralMdf);
     }
   Type t=new Type(tMdf,in.expected.getPath(),Doc.empty());
   assert null==TypeSystem._subtype(in.p,t, in.expected);
   Block annotated=new Block(s.getDoc(),dsOk.ds,e0Ok.annotated,ksOk.ks,s.getP(),t);
   TOk res=new TOk(in,annotated,t);
   // result Tr: Tr'.capture(p,ks') U Tr U Tr0
   Tr trCaptured=dsOk.trAcc;
   for(On k : ks){
     trCaptured=trCaptured.trCapture(in.p,k);
     }
   Tr trUnion = trCaptured.trUnion(ksOk.trAcc).trUnion(e0Ok);
   res=res.trUnion(trUnion);
   return res;
  }

  default TOutDs dsType(TIn in,List<Dec> _ds){
    if(_ds.isEmpty()){return new TOkDs(Tr.instance,_ds,TInG.instance.addGG(in));}
    int iSplit=splitDs(in,_ds);
    assert iSplit+1<=_ds.size();
    List<Dec> ds=_ds.subList(iSplit+1,_ds.size());//ds after split point
    List<Dec> ds0n=_ds.subList(0,iSplit+1);       //ds before split point
    List<String> fve0n=new ArrayList<>();
    for(Dec di:ds0n){
      fve0n.addAll(FreeVariables.of(di.getInner()));
      }
    assert !fve0n.stream()//the split is a correct split
      .anyMatch(x->ds.stream()
        .anyMatch(d->d.getX().equals(x)));
    //---- split part start
    TIn in1 = addMutImmAsFwdToG(in, ds0n); //G'
    Tr trAcc=Tr.instance;
    List<Dec>ds1=new ArrayList<>();
    List<Dec>ds1FwdP=new ArrayList<>();
    for(Dec di:ds0n){
      Type nt=di.getT().get();
      Type ntFwdP=TypeManipulation.fwdP(nt);
      TOut _out=type(in1.withE(di.getInner(),ntFwdP));//type all the ei
      if(!_out.isOk()){return _out.toError();}
      TOk ok=_out.toOk();
      trAcc=trAcc.trUnion(ok);
      Dec di1=di.withInner(ok.annotated);
      ds1.add(di1);
      ds1FwdP.add(di1.withVar(false).with_t(TypeManipulation.fwdP(di.get_t())));
      }
    if(TypeManipulation.fwd_or_fwdP_in(trAcc.returns)){
      boolean xInCommon=fve0n.stream().anyMatch(x->ds0n.stream().anyMatch(d->d.getX().equals(x)));
      if(xInCommon){return new TErr(in,"",null,ErrorKind.AttemptReturnFwd);}
      }
    List<Type> _nts=new ArrayList<>();
    for(String x: fve0n){
      Type t=in._g(x);
      if(t!=null){_nts.add(t);}
      }
    TIn inG0;
    if(TypeManipulation.fwd_or_fwdP_in(_nts)){inG0=in.addGds(in.p,ds1FwdP);}
    else{inG0=in.addGds(in.p,ds1);}
    //-----------Split part end
    TOutDs _res= dsType(inG0,ds);
    if(!_res.isOk()){return _res.toError();}
    TOkDs res=_res.toOkDs();
    ds1.addAll(res.ds);//safe? locally created, not leaked yet.
    if(res.trAcc!=null){trAcc=trAcc.trUnion(res.trAcc);}
    return new TOkDs(trAcc,ds1,res.g);
    }

default TIn addMutImmAsFwdToG(TIn in, List<Dec> ds0n) {
List<Dec> dsFiltered = ds0n.stream().filter(
      d->d.get_t().getMdf().isIn(Mdf.Immutable,Mdf.Mutable))
      .map(d->d.withVar(false).with_t(TypeManipulation.fwd(d.getT().get())))
      .collect(Collectors.toList());
TIn in1=in.addGds(in.p,dsFiltered);
return in1;
}
  default Type suggest(Optional<Type> option,Type alternative) {
    if (option.isPresent()) {return option.get();}
    if(!alternative.getMdf().equals(Mdf.Capsule)) {return alternative;}
    return alternative.withMdf(Mdf.Mutable);
    }
  default TOutKs ksType(TIn in,Tr trAcc,List<On> ks){
//   D| Tr |-k1..kn ~> k'1..k'n:T1..Tn <= T | Tr1 U .. U Trn
//     forall i in 1..n D| Tr.capture(D.p,k1..ki-1)|-ki ~> k'i:Ti <= T |Tri
    assert trAcc!=null;
    Tr tr=trAcc;
    Tr newTrAcc=Tr.instance;
    List<On>ks1=new ArrayList<>();
    List<Type>ts=new ArrayList<>();
    for(On k:ks){
      TOutK out=kType(in,tr,k);
      if(!out.isOk()){return out.toError();}
      TOkK ok=out.toOkK();
      ks1.add(ok.k);
      ts.add(ok.t);
      newTrAcc=newTrAcc.trUnion(ok.tr);
      }

    TOkKs res=new TOkKs(newTrAcc,ks1,ts);
    return res;
    }

  default TOutK kType(TIn in,Tr tr,On k){
    if(TypeManipulation.catchRethrow(k)){return kTypeCatchAny(in,tr,k);}
    boolean preciseApplicable=
      k.getKind()==SignalKind.Return &&
      k.getT().equals(Path.Any().toImmNT()) &&
      k.getE().equals(new ExpCore.X(Ast.Position.noInfo, k.getX())) &&
      tr.returns.stream().allMatch(t->
        TypeSystem.subtype(in.p, t.getPath(),in.expected.getPath())==null
        );
    if (preciseApplicable){return kTypeCatchPreciseAny(in, tr, k);}
    return kTypeCatch(in,tr,k);
    }

  default TOutK kTypeCatch(TIn in,Tr tr1,On k){
    if(k.getKind()==SignalKind.Return && tr1.returns.isEmpty()){
      return new TErr(in,"No returns in scope",null,ErrorKind.NoMostGeneralMdf);
      }
    Mdf mdf=TypeManipulation._mostGeneralMdf(k.getKind(),tr1);
    if(mdf==null){
    return new TErr(in,"Contrasting mdf expected for return",null,ErrorKind.NoMostGeneralMdf);
    }
    assert mdf!=Mdf.MutablePFwd && mdf!=Mdf.ImmutablePFwd;
    Type T0 = k.getT().withMdf(mdf);
    if(mdf==Mdf.Class && T0.getPath() != Path.Any()){
      Stream<MethodWithType> s = in.p.extractClassB(T0.getPath()).mwts().stream();
      if(s.noneMatch(mwt->mwt.getMt().getMdf()==Mdf.Class)){
        return new TErr(in,"Can not capture 'class "+T0.getPath()+"'; no class methods inside of "+T0.getPath(),null,ErrorKind.NoMostGeneralMdf);
        }
      }
    TOut _out=type(in.addG(k.getX(),false,T0).withE(k.getE(), in.expected));
    if(!_out.isOk()){return _out.toError();}
    TOk out=_out.toOk();
    TOkK res=new TOkK(Tr.instance.trUnion(out),k.withE(out.annotated).withT(T0),out.computed);
    return res;
     /*   Phase| p| G| Tr' |- catch throw T0 x e ~> catch throw T1.P x e' :T2 <= T | Tr
     mdf1 = mostGeneralMdf(throw,Tr') //set of Mdfs admits no single most general mdf, or mdfs is empty
     //inconsistent set of thrown things, which do not share a most
     //general modifier [list of line numbers of the throws]
     T1 = mdf1 resolve (p, T0).P //resolve can fail
     not catchRethrow(catch throw T1 x e)
     Phase| p| G[x:T1]|- e ~> e' : T2 <= T | Tr
*/
    }
  default TOutK kTypeCatchPreciseAny(TIn in,Tr tr,On k){
    assert k.getKind()==SignalKind.Return;
    assert k.getT().equals(Path.Any().toImmNT());
    assert !TypeManipulation.catchRethrow(k);
    assert k.getE() instanceof ExpCore.X;
    assert k.getE().equals(new ExpCore.X(Ast.Position.noInfo, k.getX()));
    Path exp=in.expected.getPath();
    return kTypeCatch(in, tr, k.withT(k.getT().withPath(exp)));
  }
  default TOutK kTypeCatchAny(TIn in,Tr tr,On k){
    Block e=(Block) k.getE();
    ExpCore e0=e.getDecs().get(0).getInner();
    TIn in1=in.removeG(k.getX());
    TOut _out=type(in1.withE(e0,Path.Void().toImmNT()));
    if(!_out.isOk()){return _out.toError();}
    TOk ok=_out.toOk();
    if(!ok.exceptions.isEmpty() ||!ok.returns.isEmpty()){return new TErr(in,"",null,ErrorKind.UnsafeCatchAny);}
    ExpCore newE=e.withDeci(0,e.getDecs().get(0).withInner(ok.annotated));
    return new TOkK(tr,k.withE(newE),in.expected);
    /*
   (catch and rethrow any)// could be sugared as "on throw doAndPropagate e"
   Phase |p |G |Tr|-catch throw Any x (e0 throw x) ~> catch throw Any x (e0' throw x): T<=T | Tr
     where //Note: e0, e, e0',e' are using the sugar imm Void x=e == e
     e0=(e catch error Any z void void)
     e0'=(e' catch error Any z void void)
     Phase |p |G\x |- e ~> e':_ <=imm Void | empty
     catchRethrow(catch throw Any x(e0 throw x))
*/
  }

//we are discussing if some blocks may not be promotable:
//for example blocks with empty ds and ks.

default TOut tsBlockPromotion(TIn in,Block s){
  //Phase |p |G |- (ds ks e)~>(ds' ks' e'):capsule P <=capsule P | Tr
  //  Phase |p |toLent(G) |-(ds ks e)~>(ds' ks' e'):mut P <=mut P   | Tr
  assert in.expected.getMdf().isIn(Mdf.Capsule,Mdf.Immutable,Mdf.ImmutableFwd,Mdf.ImmutablePFwd):
    in.expected.getMdf();

  TIn in2=in.toLent();
  TOut out=type(in2.withE(in.e,in.expected.withMdf(Mdf.Mutable)));
  if(!out.isOk()){return out;}
  TOk ok=out.toOk();
  return new TOk(in,ok.annotated,ok.computed.withMdf(Mdf.Capsule));
//this rule is now "deterministic" in the sense that if typing the block give us a capsule directly,
//this rule can not be applied, since we require mut P <=mut P in the premise.
  }


default TErr combine(TErr res,TErr promFail){
  return new TErr(res.in,res.msg
  +"\n(Block promotion attempted but\n"+promFail.in+"\n failed)",res._computed,res.kind);
  }

default boolean promotionMakesSense(TIn in,TErr tErr){
    Type expected=in.expected;
    Type obtained=tErr._computed;
    if(expected==null || obtained==null){return false;}
    if (null!=TypeSystem.subtype(in.p,obtained.getPath(), expected.getPath())){return false;}
    boolean acceptableEM=expected.getMdf().isIn(
        Mdf.Capsule,Mdf.Immutable,Mdf.ImmutableFwd,Mdf.ImmutablePFwd);
    return acceptableEM && obtained.getMdf()==Mdf.Mutable;
  }

}
