package is.L42.connected.withSafeOperators.location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ast.Ast;
import ast.Ast.MethodType;
import ast.Ast;
import ast.Ast.Path;
import ast.ExpCore.ClassB;
import ast.ExpCore.ClassB.MethodWithType;
import is.L42.connected.withSafeOperators.pluginWrapper.RefactorErrors.NotAvailable;
import programReduction.Program;

public class Method extends Location.LocationImpl<ClassB.MethodWithType, Lib>{
  public Method(MethodWithType inner, Lib location) {
    super(inner, location);
    }
  public static Method of(MethodWithType inner,ClassB top,List<Ast.C>cs){
    return new Method(inner,Lib.newFromLibrary(top).navigateCs(cs));
    }
  public static Method of(MethodWithType inner,Program p,Path path){
    return new Method(inner,Lib.newFromClassP(p, path));
    }
  public boolean isAbstract(){return inner.get_inner()==null;}
  public boolean isRefine(){return inner.getMt().isRefine();}
  public Ast.MethodSelector  selector(){return inner.getMs();}
  public String toS() {return sugarVisitors.ToFormattedText.of(this.inner);}
  @Override public Doc doc() {return new Doc(inner.getDoc(),this);}

  public Type.Return returnType(){return new Type.Return(inner.getMt().getReturnType(),inner,this);}
    
  Cacher<List<Type.Parameter>> parametersC=new Cacher<List<Type.Parameter>>(){public List<Type.Parameter> cache(){
    MethodType mt = inner.getMt();
    Ast.Type thisT=new Ast.Type(mt.getMdf(),Path.outer(0),Ast.Doc.empty());
    List<Type.Parameter> res=new ArrayList<>();
    res.add(new Type.Parameter(0,thisT,inner,Method.this));
    {int i=0; for(Ast.Type ti:mt.getTs()){i+=1; //starts from 1
      res.add(new Type.Parameter(i,ti,inner,Method.this));
    }}
    return res;
    }};
 
  public int parameterTypeSize(){return parametersC.get().size();}
  public Type.Parameter parameterType(int that) throws NotAvailable{return Location.listAccess(parametersC.get(), that);}
  

  Cacher<List<Type.Exception>> exceptionsC=new Cacher<List<Type.Exception>>(){public List<Type.Exception> cache(){
  MethodType mt = inner.getMt();
  List<Type.Exception> res=new ArrayList<>();
  {int i=-1; for(Ast.Type ti:mt.getExceptions()){i+=1; //starts from 0
    res.add(new Type.Exception(i,ti,inner,Method.this));
  }}
  return res;
  }};
  public int exceptionTypeSize(){return exceptionsC.get().size();}
  public Type.Exception exceptionType(int that) throws NotAvailable{
    return Location.listAccess(exceptionsC.get(), that);}
  //@Override public boolean equalequal(Object that) {return this.equals(that);}
  }
