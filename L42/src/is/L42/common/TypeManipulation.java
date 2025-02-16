package is.L42.common;

import static is.L42.tools.General.L;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import is.L42.generated.Core;
import is.L42.generated.Core.Doc;
import is.L42.generated.Core.T;
import is.L42.generated.Full;
import is.L42.generated.Mdf;
import is.L42.generated.P;
import is.L42.generated.S;

public class TypeManipulation {

  public static boolean fwd_or_fwdP_inMdfs(Stream<Mdf> mdfs){
    return mdfs.anyMatch(m->m.isIn(Mdf.ImmutableFwd,Mdf.ImmutablePFwd,Mdf.MutableFwd,Mdf.MutablePFwd));
    }
  public static Core.T capsuleToLent(Core.T t){
    if(t.mdf()==Mdf.Capsule){return t.withMdf(Mdf.Lent);}
    return t;
    }
  public static Core.T _toRead(Core.T t){
    if(t.mdf().isIn(Mdf.MutableFwd,Mdf.MutablePFwd)){return null;}
    if(t.mdf().isIn(Mdf.ImmutableFwd,Mdf.ImmutablePFwd)){return null;}
    if(t.mdf().isIn(Mdf.Lent,Mdf.Mutable,Mdf.Capsule)){
      return t.withMdf(Mdf.Readable);
      }
    return t;//imm, read, class
    }  
  public static Core.MH toCore(Full.MH mh){
    Mdf mdf=mh._mdf();
    if(mdf==null){mdf=Mdf.Immutable;}
    T t=toCore(mh.t());
    S s=mh.key();
    List<T> pars=toCoreTs(mh.pars());
    List<T> exceptions=toCoreTs(mh.exceptions());
    return new Core.MH(mdf, toCoreDocs(mh.docs()), t, s, pars, exceptions);
    }
  public static List<Core.Doc> toCoreDocs(List<Full.Doc> docs){
    return L(docs,(c,d)->c.add(toCore(d)));
    }
  public static List<Core.T> toCoreTs(List<Full.T> ts){
    return L(ts,(c,t)->c.add(toCore(t)));
    }
    
  public static T toCore(Full.T t){
    assert t.cs().isEmpty() && t._p()!=null;
    Mdf mdf=t._mdf();
    if(mdf==null){mdf=Mdf.Immutable;}
    return new T(mdf,toCoreDocs(t.docs()),t._p());
    }
  public static Core.Doc toCore(Full.Doc doc){
    return new Core.Doc(_toCore(doc._pathSel()),doc.texts(), toCoreDocs(doc.docs()));
    }
  public static Core.PathSel _toCore(Full.PathSel _p){
    if(_p==null){return null;}
    if(_p._p()==null && _p.cs().isEmpty()){
      return new Core.PathSel(P.coreThis0.p(),_p._s(),_p._x());
      }
    assert _p._p()!=null;
    return new Core.PathSel(_p._p(),_p._s(),_p._x());
    }
  public static Stream<P.NCs> skipThis0(Stream<P.NCs> s){
    return s.filter(p->p.n()>0).map(p->p.toNCs().withN(p.n()-1));
    }
  }
