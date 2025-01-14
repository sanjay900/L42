// Generated by delombok at Wed Oct 02 12:22:40 NZDT 2019
package is.L42.generated;

import java.util.List;
import is.L42.visitors.CloneVisitor;
import is.L42.visitors.CollectorVisitor;
import is.L42.visitors.Visitable;
import is.L42.common.Constants;
import static is.L42.tools.General.*;

public final class X implements Visitable<X> {
  @Override
  public X accept(CloneVisitor cv) {
    return cv.visitX(this);
  }

  @Override
  public void accept(CollectorVisitor cv) {
    cv.visitX(this);
  }

  @Override
  public String toString() {
    return Constants.toS.apply(this);
  }

  @Override
  public boolean wf() {
    return Constants.wf.test(this);
  }

  private final String inner;
  public static final X thisX = new X("this");
  public static final X thatX = new X("that");
  public static final List<X> thatXs = L(new X("that"));

  @java.lang.SuppressWarnings("all")
  public X(final String inner) {
    this.inner = inner;
  }

  @java.lang.SuppressWarnings("all")
  public String inner() {
    return this.inner;
  }

  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  public boolean equals(final java.lang.Object o) {
    if (o == this) return true;
    if (!(o instanceof X)) return false;
    final X other = (X) o;
    final java.lang.Object this$inner = this.inner();
    final java.lang.Object other$inner = other.inner();
    if (this$inner == null ? other$inner != null : !this$inner.equals(other$inner)) return false;
    return true;
  }

  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $inner = this.inner();
    result = result * PRIME + ($inner == null ? 43 : $inner.hashCode());
    return result;
  }

  @java.lang.SuppressWarnings("all")
  public X withInner(final String inner) {
    return this.inner == inner ? this : new X(inner);
  }
}
