package ast;
//import environment.Environment;

public abstract class ASTexpression{

  public abstract String toString();
  public abstract Object eval(/*Environment env*/);

}
