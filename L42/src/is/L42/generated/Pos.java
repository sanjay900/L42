// Generated by delombok at Sun Aug 04 10:32:46 PETT 2019
package is.L42.generated;

public final class Pos {
	private final String fileName;
	private final int line;
	private final int column;

	@java.lang.SuppressWarnings("all")
	public Pos(final String fileName, final int line, final int column) {
		this.fileName = fileName;
		this.line = line;
		this.column = column;
	}

	@java.lang.SuppressWarnings("all")
	public String fileName() {
		return this.fileName;
	}

	@java.lang.SuppressWarnings("all")
	public int line() {
		return this.line;
	}

	@java.lang.SuppressWarnings("all")
	public int column() {
		return this.column;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this) return true;
		if (!(o instanceof Pos)) return false;
		final Pos other = (Pos) o;
		final java.lang.Object this$fileName = this.fileName();
		final java.lang.Object other$fileName = other.fileName();
		if (this$fileName == null ? other$fileName != null : !this$fileName.equals(other$fileName)) return false;
		if (this.line() != other.line()) return false;
		if (this.column() != other.column()) return false;
		return true;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final java.lang.Object $fileName = this.fileName();
		result = result * PRIME + ($fileName == null ? 43 : $fileName.hashCode());
		result = result * PRIME + this.line();
		result = result * PRIME + this.column();
		return result;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "Pos(fileName=" + this.fileName() + ", line=" + this.line() + ", column=" + this.column() + ")";
	}

	@java.lang.SuppressWarnings("all")
	public Pos withFileName(final String fileName) {
		return this.fileName == fileName ? this : new Pos(fileName, this.line, this.column);
	}

	@java.lang.SuppressWarnings("all")
	public Pos withLine(final int line) {
		return this.line == line ? this : new Pos(this.fileName, line, this.column);
	}

	@java.lang.SuppressWarnings("all")
	public Pos withColumn(final int column) {
		return this.column == column ? this : new Pos(this.fileName, this.line, column);
	}
}