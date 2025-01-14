package is.L42.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

import is.L42.common.EndError;
import is.L42.common.Err;
import is.L42.common.G;
import is.L42.common.Parse;
import is.L42.common.Program;
import is.L42.common.Program.InvalidImplements;
import is.L42.common.Program.PathNotExistent;
import is.L42.generated.Core;
import is.L42.generated.Full;
import is.L42.generated.P;
import is.L42.generated.Pos;
import is.L42.tools.AtomicTest;
import is.L42.top.Top;
import is.L42.translationToJava.J;
import is.L42.visitors.FullL42Visitor;
import is.L42.visitors.WellFormedness.NotWellFormed;

import static is.L42.tests.TestHelpers.*;
import static is.L42.tools.General.L;
import static is.L42.tools.General.range;
import static is.L42.tools.General.unreachable;
import static is.L42.common.Err.hole;

import static org.junit.jupiter.api.Assertions.*;

public class TestExpressionJ
extends AtomicTest.Tester{public static Stream<AtomicTest>test(){return Stream.of(new AtomicTest(()->
  je("Any<:class Any","Resources.ofPath(\"L42Any\")")
  ),new AtomicTest(()->
  je("Library<:class Any","Resources.ofPath(\"L42Library\")")
  ),new AtomicTest(()->
  je("Void<:class Any","Resources.ofPath(\"L42Void\")")
  ),new AtomicTest(()->
  je("This0.A<:class This0.A","£cA£n1.instance")
  ),new AtomicTest(()->
  je("This0.B<:class This0.B","£cB£n1.instance")
  ),new AtomicTest(()->
  je("This0.A<:class Any","Resources.ofPath(\"£cA£n1\")")
  ),new AtomicTest(()->
  je("This0.B<:class Any","Resources.ofPath(\"£cB£n1\")")
  ),new AtomicTest(()->
  je("void","L42Void.instance")
  ),new AtomicTest(()->
  je("{#norm{}}","Resources.ofLib(\"1\")")
    ),new AtomicTest(()->
  je("{#typed{}}","Resources.ofLib(\"1\")")
    ),new AtomicTest(()->
  je("This0.A<:class This0.A.ma(a=This0.A<:class This0.A.of())","£cA£n1.£mma£xa(£cA£n1.instance,£cA£n1.£mof(£cA£n1.instance))")
    ),new AtomicTest(()->
  je("This0.B<:class This0.B.mb(b=This0.B<:class This0.B.of())","£cB£n1.£mmb£xb(£cB£n1.instance,£cB£n1.£mof(£cB£n1.instance))")
    ),new AtomicTest(()->
  je("loop void","switch(0){default->{if(false)yield Resources.throwE(null);while(true)L42Void.instance;}}")
    ),new AtomicTest(()->
  je("return void","Resources.throwE(new L42Return(L42Void.instance))")
  //op update needs blocks
  ),new AtomicTest(()->
  je("(void)","L42Void.instance")
  ),new AtomicTest(()->
  je("(This0.A a=This0.A<:class This0.A.of() a)","""
    switch(0){default->{
      £cA£n1 £xa=null;
      £xa=£cA£n1.£mof(£cA£n1.instance);
      yield £xa;
      }}
    """)
  ),new AtomicTest(()->
  je("(var This0.A a=This0.A<:class This0.A.of() a:=a)","""
    switch(0){default->{
      £cA£n1 £xa=null;
      £xa=£cA£n1.£mof(£cA£n1.instance);
      yield Resources.toVoid(£xa=£xa);
      }}
    """)
  ),new AtomicTest(()->//template, next tests will be similar
  je("""
   (var This0.A a=This0.A<:class This0.A.of()
    This0.A a0=a
    a.ma(a=a)
    )""","""
    switch(0){default->{
      £cA£n1 £xa=null;
      £cA£n1 £xa0=null;
      £xa=£cA£n1.£mof(£cA£n1.instance);
      £xa0=£xa;
      yield £cA£n1.£mma£xa(£xa,£xa);
      }}
    """)
  ),new AtomicTest(()->//using Any for a0
  je("""
   (var This0.A a=This0.A<:class This0.A.of()
    Any a0=a
    a.ma(a=a)
    )""","""
    switch(0){default->{
      £cA£n1 £xa=null;
      L42Any £xa0=null;
      £xa=£cA£n1.£mof(£cA£n1.instance);
      £xa0=£xa;
      yield £cA£n1.£mma£xa(£xa,£xa);
      }}
    """)
  ),new AtomicTest(()->//using B instead of A
  je("""
   (var This0.B b=This0.B<:class This0.B.of()
    This0.B b0=b
    b.mb(b=b)
    )""","""
    switch(0){default->{
      Foo £xb=null;
      Foo £xb0=null;
      £xb=£cB£n1.£mof(£cB£n1.instance);
      £xb0=£xb;
      yield £cB£n1.£mmb£xb(£xb,£xb);
      }}
    """)
  ),new AtomicTest(()->//B instead of A, Any for b0
  je("""
   (var This0.B b=This0.B<:class This0.B.of()
    Any b0=b
    b.mb(b=b)
    )""","""
    switch(0){default->{
      Foo £xb=null;
      L42Any £xb0=null;
      £xb=£cB£n1.£mof(£cB£n1.instance);
      £xb0=£cB£n1.wrap(£xb);
      yield £cB£n1.£mmb£xb(£xb,£xb);
      }}
    """)
  ),new AtomicTest(()->//throwing a B and an A
  je("""
   (This0.A a=This0.A<:class This0.A.of()
    This0.B b=This0.B<:class This0.B.of()
    Void v0=error a
    Void v1=error b
    void
    )""","""
    switch(0){default->{
      £cA£n1 £xa=null;
      Foo £xb=null;
      L42Void £xv0=null;
      L42Void £xv1=null;
      £xa=£cA£n1.£mof(£cA£n1.instance);
      £xb=£cB£n1.£mof(£cB£n1.instance);
      £xv0=Resources.throwE(new L42Error(£xa));
      £xv1=Resources.throwE(new L42Error(£cB£n1.wrap(£xb)));
      yield L42Void.instance;
      }}
    """)

  ),new AtomicTest(()->//using fwds
  je("""
   (This0.A a=This0.A<:class This0.A.of()
    This0.A a0=a.ma(a=a0)
    a0
    )""","""
    switch(0){default->{
      £cA£n1 £xa=null;
      £cA£n1 £xa0=null;
      £cA£n1 £xa0£fwd=£cA£n1.NewFwd();
      £xa=£cA£n1.£mof(£cA£n1.instance);
      £xa0=£cA£n1.£mma£xa(£xa,£xa0£fwd);
      ((L42Fwd)£xa0£fwd).fix(£xa0);
      yield £xa0;
      }}
    """)
  ),new AtomicTest(()->//using fwds
  je("""
   (This0.B b=This0.B<:class This0.B.of()
    This0.B b0=b.mb(b=b0)
    b0
    )""","""
    switch(0){default->{
      Foo £xb=null;
      Foo £xb0=null;
      Object £xb0£fwd=£cB£n1.NewFwd();
      £xb=£cB£n1.£mof(£cB£n1.instance);
      £xb0=£cB£n1.£mmb£xb(£xb,£xb0£fwd);
      ((L42Fwd)£xb0£fwd).fix(£xb0);
      yield £xb0;
      }}
    """)

  ),new AtomicTest(()->//throw
  je("""
   (This0.B b=This0.B<:class This0.B.of()
    This0.B b0=b.mb(b=b0)
    catch error This0.B x x
    b0
    )""","""
    switch(0){default->{
      Foo £xb=null;
      Foo £xb0=null;
      Object £xb0£fwd=£cB£n1.NewFwd();
      try{
        £xb=£cB£n1.£mof(£cB£n1.instance);
        £xb0=£cB£n1.£mmb£xb(£xb,£xb0£fwd);
        ((L42Fwd)£xb0£fwd).fix(£xb0);
        }
      catch(L42Error catchVar0){
        if(catchVar0.obj42() instanceof £cB£n1){
          Foo £xx=((£cB£n1)catchVar0.obj42()).unwrap;
          yield £xx;
          }
        throw catchVar0;
        }
      yield £xb0;
      }}
    """
    //eclipse bug: if I put umbalanced "}" in the code literal, the parser may fails. It also fails if the same multiline string is embedded in /* */
    )


//jc
  ),new AtomicTest(()->
  jc("""
     """,
     """
     class £cN£n1 implements L42Any{
       public static int £mof(£cN£n1 £xthis){
         return 0;
         }
       public static int £msum£xthat(int £xthis, int £xthat){
         return £xthis + £xthat;
         }
       public static £cN£n1 NewFwd(){return new _Fwd();}
       public static class _Fwd extends £cN£n1 implements L42Fwd{
         private List<Object> os=new ArrayList<>();
         private List<BiConsumer<Object,Object>> fs=new ArrayList<>();
         public List<Object> os(){return os;}
         public List<BiConsumer<Object,Object>> fs(){return fs;}
         }
       public static final £cN£n1 instance=new _Fwd();
       public int unwrap;
       public static £cN£n1 wrap(int that){£cN£n1 res=new £cN£n1();res.unwrap=that;return res;}
       }
     ""","""
     class £cA£n1 implements L42Any{
       public static £cA£n1 £mof£xn(£cA£n1 £xthis, int £xn){
         £cA£n1 Res=new £cA£n1();
         Res.£xn=£xn;
         return Res;
         }
       public static int £mn(£cA£n1 £xthis){
         return £xthis.£xn;
         }
       public static L42Void £mn£xthat(£cA£n1 £xthis, int £xthat){
         £xthis.£xn=£xthat;return L42Void.instance;
         }
       int £xn;
       public static BiConsumer<Object,Object> FieldAssFor_n=(f,o)->{((£cA£n1)o).£xn=(int)f;};
       public static £cA£n1 NewFwd(){return new _Fwd();}
       public static class _Fwd extends £cA£n1 implements L42Fwd{
         private List<Object> os=new ArrayList<>();
         private List<BiConsumer<Object,Object>> fs=new ArrayList<>();
         public List<Object> os(){return os;}
         public List<BiConsumer<Object,Object>> fs(){return fs;}
         }
       public static final £cA£n1 instance=new _Fwd();
       }
     """)
  ),new AtomicTest(()->
  jc("""
     C={ #norm{}}
     ""","""
     class £cC£n1 implements L42Any{
       public static £cC£n1 NewFwd(){return new _Fwd();}
       public static class _Fwd extends £cC£n1 implements L42Fwd{
         private List<Object> os=new ArrayList<>();
         private List<BiConsumer<Object,Object>> fs=new ArrayList<>();
         public List<Object> os(){return os;}
         public List<BiConsumer<Object,Object>> fs(){return fs;}
         }
       public static final £cC£n1 instance=new _Fwd();
       }
     ""","","")
  ),new AtomicTest(()->
  jc("""
     C={ 
       class method mut This0 of(fwd imm This1.N n)
       method This1.N n()
       #norm{}}
     ""","""
       class £cC£n1 implements L42Any{
         public static £cC£n1 £mof£xn(£cC£n1 £xthis, Object £xn){
           £cC£n1 Res=new £cC£n1();
           if(£xn instanceof L42Fwd){((L42Fwd)£xn).add(Res,JC.FieldAssFor_ £xn);}else{Res.£xn=(int)£xn;}
           return Res;
           }
         public static int £mn(£cC£n1 £xthis){
           return £xthis.£xn;
           }
         int £xn;
         public static BiConsumer<Object,Object> FieldAssFor_n=(f,o)->{((£cC£n1)o).£xn=(int)f;};
         public static £cC£n1 NewFwd(){return new _Fwd();}
         public static class _Fwd extends £cC£n1 implements L42Fwd{
           private List<Object> os=new ArrayList<>();
           private List<BiConsumer<Object,Object>> fs=new ArrayList<>();
           public List<Object> os(){return os;}
           public List<BiConsumer<Object,Object>> fs(){return fs;}
           }
         public static final £cC£n1 instance=new _Fwd();
         }
     ""","","")

  ));}
public static void je(String e,String out){
  String l="{ method Void m()="+e+" A={class method This0 of() method Void ma(This0 a) #norm{}} B={class method This0 of() method Void mb(This0 b) #norm{nativeKind=Foo}} #norm{uniqueId=id1}}";
  var p=Program.parse(l);
  J j=new J(p,G.empty(),false);
  j.visitE(p.topCore().mwts().get(0)._e());
  String res=j.result().toString();
  Err.strCmp(res,out);
  }
public static void jc(String e,String ...out){
  String l="{ "+e+
  """
  N={
    class method This0 of()
    method This0 sum(This0 that)=native{trusted:OP+} error void
    #norm{nativeKind=int}}
  A={
    class method mut This0 of(This1.N n)
    method This1.N n()
    mut method Void n(This1.N that)
    #norm{}} 
  #norm{uniqueId=id1}}
  """;
  var p=Program.parse(l);
  List<String> res=L(p.topCore().ncs(),(c,nc)->{
    var pi=p.push(nc.key());
    J j=new J(pi,G.empty(),false);
    j.mkClass();
    c.add(j.result().toString());
    });
  L(res,List.of(out),(c,r,o)->c.add(o.isEmpty() || Err.strCmp(r,o)));
  }
}