package ast;
import java.math.BigInteger;

import environment.Environment
;
public class ASTinteger extends ASTexpression {

  private final String description;
  private final BigInteger value;

  public ASTinteger (String description) {
    this.description=description;
    this.value=new BigInteger(description);
  }

	public BigInteger getValue() {
    return value;
  }

  public String toString(){
    return value.toString();
  }

  public Object eval(Environment env){
    return value;
  }


}
