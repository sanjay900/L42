package is.L42.generated;
import lombok.Value;
import lombok.experimental.Wither;

@Value @Wither public class Pos{
  String fileName; int line; int column;
  @Override public String toString(){
    return "line " + line() + ":" + column() + "\n";
    }}
