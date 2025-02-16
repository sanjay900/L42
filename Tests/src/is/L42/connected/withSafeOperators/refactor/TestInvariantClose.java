package is.L42.connected.withSafeOperators.refactor;

import static helpers.TestHelper.getClassB;
import static helpers.TestHelper.lineNumber;
import static org.junit.Assert.*;

import helpers.TestHelper;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.ClassUnfit;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.MethodClash;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.ParseFail;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.PathUnfit;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.PrivacyCoupuled;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.SelectorUnfit;
import is.L42.connected.withSafeOperators.refactor.ToAbstract;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import newTypeSystem.FormattedError;
import newTypeSystem.TIn;
import newTypeSystem.TOut;
import newTypeSystem.TypeSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import platformSpecific.javaTranslation.Resources;
import ast.Ast;
import ast.Ast.MethodSelector;
import ast.Ast.Path;
import ast.Ast.Stage;
import ast.ExpCore.ClassB;
import ast.ExpCore.ClassB.MethodWithType;
import auxiliaryGrammar.Functions;
import programReduction.Program;
@RunWith(Parameterized.class)
public class TestInvariantClose{
  @Parameter(0) public int _lineNumber;
  @Parameter(1) public String _cb1;
  @Parameter(2) public String _path;
  @Parameter(3) public String _expected;
  @Parameter(4) public boolean isError;
  @Parameters(name = "{index}: line {0}")
  public static List<Object[]> createData() {
    return Arrays.asList(new Object[][] {
    {lineNumber(), "{}","This",
    "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$ClassUnfit"
    ,true
  },{lineNumber(),
  "{A a read method Void #invariant() (void) A:{}}",
        "This",
  "  {\n" +
      "read method \n" +
      "Void #invariant_$_2() (void)\n" +
      "class method \n" +
      "mut This0 mutK_$_2(fwd This0.A a) \n" +
      "read method \n" +
      "This0.A a() this.a_$_2()\n" +
      "read method \n" +
      "This0.A a_$_2() \n" +
      "read method \n" +
      "Void #invariant() (void)\n" +
      "class method \n" +
      "mut This0 mutK(This0.A a) (\n" +
      "  r1=this.mutK_$_2(a:a)\n" +
      "  Void unused1=r1.#invariant_$_2()\n" +
      "  r1\n" +
      "  )\n" +
      "class method \n" +
      "This0 immK(This0.A a) (\n" +
      "  This0 r2=this.mutK_$_2(a:a)\n" +
      "  Void unused2=r2.#invariant_$_2()\n" +
      "  r2\n" +
      "  )\n" +
      "A: {}}"
  ,false
  },{lineNumber(),
  "{var A a read method Void #invariant() (a = this.a() void) A:{}}","This",
  " {\n" +
      "read method \n" +
      "Void #invariant_$_2() (\n" +
      "  a=this.a_$_2()\n" +
      "  void\n" +
      "  )\n" +
      "class method \n" +
      "mut This0 mutK_$_2(fwd This0.A a) \n" +
      "mut method \n" +
      "Void a(This0.A that) (\n" +
      "  r1=this.a_$_2(that:that)\n" +
      "  Void unused1=this.#invariant_$_2()\n" +
      "  r1\n" +
      "  )\n" +
      "mut method \n" +
      "Void a_$_2(This0.A that) \n" +
      "read method \n" +
      "This0.A a() this.a_$_2()\n" +
      "read method \n" +
      "This0.A a_$_2() \n" +
      "read method \n" +
      "Void #invariant() (\n" +
      "  a=this.a()\n" +
      "  void\n" +
      "  )\n" +
      "class method \n" +
      "mut This0 mutK(This0.A a) (\n" +
      "  r2=this.mutK_$_2(a:a)\n" +
      "  Void unused2=r2.#invariant_$_2()\n" +
      "  r2\n" +
      "  )\n" +
      "class method \n" +
      "This0 immK(This0.A a) (\n" +
      "  This0 r3=this.mutK_$_2(a:a)\n" +
      "  Void unused3=r3.#invariant_$_2()\n" +
      "  r3\n" +
      "  )\n" +
      "A: {}}"
  ,false

  },{lineNumber(),
  "{capsule A a read method Void #invariant() void "
  + " mut method Void doStuff(A that)that(this.#a()) A:{method Void(read A that) void}}","This",
  " {\n" +
      "read method \n" +
      "Void #invariant_$_2() void\n" +
      "class method \n" +
      "mut This0 mutK_$_2(fwd mut This0.A a) \n" +
      "read method \n" +
      "read This0.A a() this.a_$_2()\n" +
      "read method \n" +
      "read This0.A a_$_2() \n" +
      "mut method \n" +
      "lent This0.A #a() this.#a_$_2()\n" +
      "mut method \n" +
      "lent This0.A #a_$_2() \n" +
      "read method \n" +
      "Void #invariant() void\n" +
      "mut method \n" +
      "Void doStuff(This0.A that) that.#apply(that:this.#a())\n" +
      "class method \n" +
      "mut This0 mutK(capsule This0.A a) (\n" +
      "  r1=this.mutK_$_2(a:a)\n" +
      "  Void unused1=r1.#invariant_$_2()\n" +
      "  r1\n" +
      "  )\n" +
      "class method \n" +
      "This0 immK(This0.A a) (\n" +
      "  This0 r2=this.mutK_$_2(a:a)\n" +
      "  Void unused2=r2.#invariant_$_2()\n" +
      "  r2\n" +
      "  )\n" +
      "A: {\n" +
      "method \n" +
      "Void #apply(read This1.A that) void}}"
  ,false

  },{lineNumber(),
  "{capsule A a read method Void #invariant() void mut method Void mutA()( lent A a=this.#a() void) A:{}}","This",
  " {\n" +
      "read method \n" +
      "Void #invariant_$_2() void\n" +
      "class method \n" +
      "mut This0 mutK_$_2(fwd mut This0.A a) \n" +
      "read method \n" +
      "read This0.A a() this.a_$_2()\n" +
      "read method \n" +
      "read This0.A a_$_2() \n" +
      "mut method \n" +
      "lent This0.A #a() this.#a_$_2()\n" +
      "mut method \n" +
      "lent This0.A #a_$_2() \n" +
      "read method \n" +
      "Void #invariant() void\n" +
      "mut method \n" +
      "Void mutA() (\n" +
      "  lent This0.A a=this.#a()\n" +
      "  void\n" +
      "  )\n" +
      "class method \n" +
      "mut This0 mutK(capsule This0.A a) (\n" +
      "  r1=this.mutK_$_2(a:a)\n" +
      "  Void unused1=r1.#invariant_$_2()\n" +
      "  r1\n" +
      "  )\n" +
      "class method \n" +
      "This0 immK(This0.A a) (\n" +
      "  This0 r2=this.mutK_$_2(a:a)\n" +
      "  Void unused2=r2.#invariant_$_2()\n" +
      "  r2\n" +
      "  )\n" +
      "A: {}}"
  ,false

  },{lineNumber(), "{B:{}}","C",
  "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$PathUnfit",true
  },{lineNumber(), "{A a "
      //+ "class method mut This ctor(fwd A a) "
      + "read method Void #invariant() void class method mut This(A a) This(a: a)  class method This k(A a) This(a: a) A:{}}","This",
  " {\n" +
      "read method \n" +
      "Void #invariant_$_2() void\n" +
      "class method \n" +
      "mut This0 mutK_$_2(fwd This0.A a) \n" +
      "read method \n" +
      "This0.A a() this.a_$_2()\n" +
      "read method \n" +
      "This0.A a_$_2() \n" +
      "read method \n" +
      "Void #invariant() void\n" +
      "class method \n" +
      "mut This0 #apply(This0.A a) This0.#apply(a:a)\n" +
      "class method \n" +
      "This0 k(This0.A a) This0.#apply(a:a)\n" +
      "class method \n" +
      "mut This0 mutK(This0.A a) (\n" +
      "  r1=this.mutK_$_2(a:a)\n" +
      "  Void unused1=r1.#invariant_$_2()\n" +
      "  r1\n" +
      "  )\n" +
      "class method \n" +
      "This0 immK(This0.A a) (\n" +
      "  This0 r2=this.mutK_$_2(a:a)\n" +
      "  Void unused2=r2.#invariant_$_2()\n" +
      "  r2\n" +
      "  )\n" +
      "A: {}}",false
  //

    },{lineNumber(), "{read method Void #invariant() (This t = this, void)}","This",
        "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$ClassUnfit", true

    },{lineNumber(), "{read method Void #invariant() this.#invariant()}","This",
        "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$ClassUnfit", true
    },{lineNumber(), "{" +
        "read method Void bar() this.#invariant()" +
        "read method Void #invariant() this.bar()}","This",
        "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$ClassUnfit", true

//    },{lineNumber(), "{read method Void #invariant() this.bar(b: void) read method Void bar(Void b)}","This",
//      "is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors$ClassUnfit", true

}});}
  @Test  public void test() throws PathUnfit, ClassUnfit, ParseFail {
  /**
   real issue here:
   some metaprogramming classes have some parsing
   at class loading time. This uses L42.usedNames.
   Caching currently does not work well with those.

     Algorithm? Load all the parsing first, then do caching
     Or normal behaviour? not clean usedNames but make it as
     after parsing meta class loaders?
   */

    /*

      {
    class method mut This(capsule Concept.ToS x);
    mut method Void x(mut Concept.ToS that);
    read method read Concept.ToS x();

    read method Bool #invariant()
    {
        this.x().toS().size() != 0Size
    }
}


     */

  TestHelper.configureForTest();
  ClassB cb1=getClassB(false,null,_cb1);
  cb1 = MakeK.makeKJ(cb1, "mutK", Collections.emptyList(),"-refine", /*imm*/ false, false);
  cb1 = MakeK.makeKJ(cb1, "immK", Collections.emptyList(),"-refine", /*imm*/ true, false);

  List<Ast.C> path=TestHelper.cs(_path);
  if(!isError){
    ClassB res=InvariantClose.close(Program.emptyLibraryProgram(), path, cb1, InvariantClose.MODE_L42);
    TypeSystem.typeCheck(res, ClassB.Phase.Coherent).assertOk();

    TestHelper.configureForTest();
    ClassB expected=getClassB(false,null,_expected);
    TestHelper.assertEqualExp(expected,res);
    }
  else{
    try{
      InvariantClose.close(Program.emptyLibraryProgram(), path, cb1, InvariantClose.MODE_L42);
      fail("error expected");
      }
    catch(ClassUnfit|PathUnfit err){
      assertEquals(_expected,((Object)err).getClass().getName());
    }
  }
}
}




