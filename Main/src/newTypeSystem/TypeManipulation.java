package newTypeSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ast.Ast.Mdf;
import ast.Ast.Type;
import ast.Ast.Type;
import ast.Ast.Path;
import ast.Ast.SignalKind;
import ast.Ast;
import ast.ExpCore;

public class TypeManipulation {

public static Type fwd(Type t){
//  fwd T
//    fwd imm P=fwd fwd%imm P=fwdImm P
//    fwd mut P=fwd fwd%mut P=fwdMut P
//    otherwise fwd T=T
  if(t.getMdf().isIn(Mdf.Immutable,Mdf.ImmutablePFwd)){
    return t.withMdf(Mdf.ImmutableFwd);
    }
  if(t.getMdf().isIn(Mdf.Mutable,Mdf.MutablePFwd)){
    return t.withMdf(Mdf.MutableFwd);
    }
  return t;
  }

public static Type fieldToFwd(Type t) {
  if (t.getMdf() == Mdf.Immutable)
    return t.withMdf(Mdf.ImmutableFwd);
  else if (t.getMdf().isIn(Mdf.Mutable,Mdf.Capsule))
    return t.withMdf(Mdf.MutableFwd);
  else
    return t;
}
public static Type fwdP(Type t){
//  fwd% T
//    fwd% imm P=fwd%Imm P
//    fwd% mut P=fwd%Mut P
//    otherwise fwd% T=T
  Mdf m=t.getMdf();
  if(m==Mdf.Immutable){
    return t.withMdf(Mdf.ImmutablePFwd);
    }
  if(m==Mdf.Mutable){
    return t.withMdf(Mdf.MutablePFwd);
    }
  return t;
  }

public static boolean fwd_or_fwdP_in(Mdf m){
  return m.isIn(Mdf.ImmutableFwd,Mdf.ImmutablePFwd,Mdf.MutableFwd,Mdf.MutablePFwd);
  }

public static boolean fwd_or_fwdP_in(Collection<? extends Type>ts){
//  fwd_or_fwd%_in Ts
//    exists T in Ts such that
//    T in {fwdImm _,fwdMut_,fwd%Imm _,fwd%Mut _}
  for(Type ti:ts){
    if(fwd_or_fwdP_in(ti.getMdf())){return true;}
    }
  return false;
  }

public static boolean fwd_or_fwdP_inMdfs(Collection<Mdf>ms){
  for(Mdf mi:ms){
    if(fwd_or_fwdP_in(mi)){return true;}
    }
  return false;
  }

public static Type noFwd(Type t){
//  noFwd T
//    noFwd fwdImm P=noFwd fwd%Imm P=imm P
//    noFwd fwdMut P=noFwd fwd%Mut P=mut P
//    otherwise noFwd T=T
  if(t.getMdf().isIn(Mdf.ImmutableFwd,Mdf.ImmutablePFwd)){
    return t.withMdf(Mdf.Immutable);
    }
  if(t.getMdf().isIn(Mdf.MutableFwd,Mdf.MutablePFwd)){
    return t.withMdf(Mdf.Mutable);
    }
  return t;
  }
public static List<Type>  noFwd(Collection<Type>ts){
//  noFwd T1..Tn= noFwd T1 .. noFwd Tn
  List<Type>res=new ArrayList<>();
  for(Type ti:ts){res.add(noFwd(ti));}
  return res;
  }

public static Type toImm(Type t) {
  return t.getMdf() == Mdf.Class ? t : t.withMdf(Mdf.Immutable);
}
/*public static NormType toImm(NormType t){//used only for fields in coherent
//  toImm(T)
//    toImm(class P)=class P
//    otherwise, toImm(mdf P)=imm P
  if(t.getMdf()==Mdf.Class){return t;}
  return t.withMdf(Mdf.Immutable);
  }*/
public static Type toImmOrCapsule(Type t){
//  toImmOrCapsule(T)
//    toImmOrCapsule(mdf C)=capsule C with mdf in {lent,mut,fwdMut,fwd%Mut}
//    toImmOrCapsule(read C)=imm C
//    otherwise toImmOrCapsule(T)=T//mdf in {class,imm,fwdImm,fwd%Imm,capsule}
  return t.withMdf(toImmOrCapsule(t.getMdf()));
  }
public static Mdf toImmOrCapsule(Mdf m){
  if (m.isIn(Mdf.Lent,Mdf.Mutable,Mdf.MutableFwd,Mdf.MutablePFwd)){
    return Mdf.Capsule;
    }
  if(m==Mdf.Readable){return Mdf.Immutable;}
  return m;
  }
public static Type _toLent(Type t){
//  toLent(T)
//    toLent(mut P)=lent P,
//    toLent(fwdMut P) and toLent(fwd%Mut P) undefined;
//    otherwise toLent(T)=T
  if(t.getMdf().isIn(Mdf.MutableFwd,Mdf.MutablePFwd)){return null;}
  if(t.getMdf()==Mdf.Mutable){return t.withMdf(Mdf.Lent);}
  return t;
  }

public static Type mutOnlyToLent(Type t){
  if(t.getMdf()==Mdf.Mutable){return t.withMdf(Mdf.Lent);}
  return t;
  }
public static Type capsuleToLent(Type t){
  if(t.getMdf()==Mdf.Capsule){return t.withMdf(Mdf.Lent);}
  return t;
  }
public static Type capsuleToFwdMut(Type t){
if(t.getMdf()==Mdf.Capsule){return t.withMdf(Mdf.MutableFwd);}
return t;
}

public static Type _toRead(Type t){
//  toRead(T)
//    toRead(fwdMut P)=toRead(fwd%Mut P)=undefined
//    toRead(fwdImm P)=toRead(fwd%Imm P)=undefined
//    toRead(lent P)=toRead(mut P)=toRead(capsule P)=read P
//    toRead(lent P)=toRead(mut P)=toRead(capsule P)=read P
//    otherwise read(T)=T//mdf in imm,read,class
  if(t.getMdf().isIn(Mdf.MutableFwd,Mdf.MutablePFwd)){return null;}
  if(t.getMdf().isIn(Mdf.ImmutableFwd,Mdf.ImmutablePFwd)){return null;}
  if(t.getMdf().isIn(Mdf.Lent,Mdf.Mutable,Mdf.Capsule)){
    return t.withMdf(Mdf.Readable);
    }
  return t;
  }


/*public static NormType lentToMut(NormType t){
//  lentToMut(T)
//    lentToMut(lent C)=mut C
//    otherwise lentToMut(T)=T
  if(t.getMdf()==Mdf.Lent){return t.withMdf(Mdf.Mutable);}
  return t;
  }*/
public static Type mutToCapsule(Type t){
//  mutToCapsule(T)
//    mutToCapsule(fwdMut C) and mutToCapsule(fwd%Mut C) undefined
//    mutToCapsule(mut C)=capsule C
//    otherwise mutToCapsule(T)=T
  Mdf _m=mutToCapsule(t.getMdf());
  if(_m==null){return null;}
  return t.withMdf(_m);
  }
public static Mdf mutToCapsule(Mdf m){
  assert !m.isIn(Mdf.MutableFwd,Mdf.MutablePFwd);
  if(m==Mdf.Mutable){return Mdf.Capsule;}
  return m;
  }

public static Type mutToCapsuleAndFwdMutToFwdImm(Type t){
//mutToCapsuleAndFwdMutToFwdImm(T) //called f in the implementation
//f(fwd%Mut P) undefined
//f(mut P)=capsule P
//f(fwdMut P)= fwdImm P
//otherwise f(T)=T
  return t.withMdf(mutToCapsuleAndFwdMutToFwdImm(t.getMdf()));
  }
public static Mdf mutToCapsuleAndFwdMutToFwdImm(Mdf m){
 assert m!=Mdf.MutablePFwd;
 if(m==Mdf.Mutable){return Mdf.Capsule;}
 if(m==Mdf.MutableFwd){return Mdf.ImmutableFwd;}
 return m;
 }
public static Type mutToCapsuleAndFwdToRead(Type t){
//mutToCapsuleAndFwdMutToRead(T) //called f in the implementation
//f(fwd%Mut P) undefined
//f(mut P)=capsule P
//f(fwdMut P)= read P
//f(fwdImm P)= imm P
//otherwise f(T)=T
  return t.withMdf(mutToCapsuleAndFwdToRead(t.getMdf()));
  }
public static Mdf mutToCapsuleAndFwdToRead(Mdf m){
  assert m!=Mdf.MutablePFwd;
  if(m==Mdf.Mutable){return Mdf.Capsule;}
  if(m==Mdf.MutableFwd){return Mdf.Readable;}
  if(m==Mdf.ImmutableFwd){return Mdf.Immutable;}
  return m;
  }

public static Mdf _mostGeneralMdf(Ast.SignalKind _throw,ATr<?> out){
//mostGeneralMdf(throw,Tr)
//  mostGeneralMdf(error,Tr)=imm
//  mostGeneralMdf(return,empty;Ps) undefined
//  mostGeneralMdf(return,T1..Tn;Ps)=mostGeneralMdf({T1.mdf .. Tn.mdf})
//  otherwise
//  mostGeneralMdf(exception,_;Ps)=imm
  if(_throw!=SignalKind.Return){return Mdf.Immutable;}
  assert !out.returns.isEmpty();
  Stream<Ast.Mdf> s = out.returns.stream().map(t->t.getMdf());
  return _mostGeneralMdf(s.collect(Collectors.toSet()));
  }
public static Mdf _mostGeneralMdf(Set<Mdf> mdfs){
//case by exclusion:
//  if mdfs=mdf', then mdf=mdf' //that is the only way mdf=class
  if (mdfs.size()==1){return mdfs.iterator().next();}
//  if class in mdfs, then undefined
  if (mdfs.contains(Mdf.Class)){return null;}
  //if mdfs\capsule=mdf', then mdf=mdf'
  if (mdfs.contains(Mdf.Capsule) && mdfs.size()==2){
    Iterator<Mdf> i = mdfs.iterator();
    Mdf m=i.next();
    if(m==Mdf.Capsule){m=i.next();}
    assert m!=Mdf.Capsule;
    return m;
    }
//  if fwd_or_fwd%_in(mdfs) {
  if(TypeManipulation.fwd_or_fwdP_inMdfs(mdfs)){
//    if read or lent in mdfs, then undefined
    if (mdfs.contains(Mdf.Readable)){return null;}
    if (mdfs.contains(Mdf.Lent)){return null;}
//  if imm and mut both in noFwd(mdfs) then undefined
    boolean mutIn=false;
    boolean immIn=false;
    for(Mdf m:mdfs){
      if(Mdf.muts.contains(m))mutIn=true;
      if(Mdf.imms.contains(m))immIn=true;
      }
    if (mutIn && immIn){return null;}
    //we know: more then one, no read/lent, either all imm side or mut side
    if(mdfs.contains(Mdf.ImmutableFwd)){return Mdf.ImmutableFwd;}
    if(mdfs.contains(Mdf.ImmutablePFwd)){return Mdf.ImmutablePFwd;}
    if(mdfs.contains(Mdf.MutableFwd)){return Mdf.MutableFwd;}
    assert mdfs.contains(Mdf.MutablePFwd): mdfs;
    return Mdf.MutablePFwd;
    }
  //if read in mdfs, mdf=read
  if(mdfs.contains(Mdf.Readable)){return Mdf.Readable;}
  if(mdfs.contains(Mdf.Immutable)){return Mdf.Readable;}
  return Mdf.Lent;
  }


public static boolean catchRethrow(ExpCore.Block.On k){
  //liberal use of desugaring in the line under
  //catchRethrow(k) iff k=catch throw Any x ((e catch error Any z void void) throw x)
  if(!k.getT().equals(Path.Any().toImmNT())){return false;}
  if(!(k.getE() instanceof ExpCore.Block)){return false;}
  ExpCore.Block b=(ExpCore.Block)k.getE();
  if(!(b.getInner() instanceof ExpCore.Signal)){return false;}
  return false;
  }


}
