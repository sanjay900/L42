package is.L42.generated;
import lombok.Value;
import lombok.EqualsAndHashCode;
import lombok.experimental.Wither;
import java.util.List;
import is.L42.visitors.CloneVisitor;
import is.L42.visitors.CollectorVisitor;
import is.L42.visitors.Visitable;
import is.L42.common.Constants;
import is.L42.common.Parse;
import static is.L42.tools.General.*;

public class P implements Visitable<P>{
  @Override public P accept(CloneVisitor cv){return cv.visitP(this);}
  @Override public void accept(CollectorVisitor cv){cv.visitP(this);}
  @Override public String toString(){return Constants.toS.apply(this);}
  @Override public boolean wf(){return Constants.wf.test(this);}
  public static final P pAny=new P();
  public static final P pVoid=new P();
  public static final P pLibrary=new P();
  public static final Core.T coreAny = new Core.T(Mdf.Immutable, L(), P.pAny);
  public static final Core.T coreLibrary = new Core.T(Mdf.Immutable, L(), P.pLibrary);
  public static final Core.T coreVoid=new Core.T(Mdf.Immutable, L(),P.pVoid);
  public static final Core.T coreThis0=new Core.T(Mdf.Immutable, L(),P.of(0,L()));
  public static final Core.T coreThis1=new Core.T(Mdf.Immutable, L(),P.of(1,L()));
  public static final Full.T fullThis0=new Full.T(Mdf.Immutable, L(),L(),coreThis0.p());
  private P(){}
  public static P.NCs of(int n,List<C>cs){return new NCs(n,cs);}
  public static P parse(String s){
    var csP= Parse.csP("--dummy--",s);
    assert !csP.hasErr();
    assert csP.res._p()!=null;
    return csP.res._p();
    }
  public boolean isNCs(){return false;}
  public NCs toNCs(){throw bug();}
  @EqualsAndHashCode(callSuper=false) @Value @Wither
  public static class NCs extends P{
    int n;List<C>cs;
    @Override public NCs toNCs(){return this;}
    @Override public boolean isNCs(){return true;}
    @Override public String toString(){return Constants.toS.apply(this);}
    }
  }