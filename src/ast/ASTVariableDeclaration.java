package ast;


public class ASTVariableDeclaration extends ASTexpression {
    private String variableName;
    private ASTexpression initialValue;

    public ASTVariableDeclaration(String variableName, ASTexpression initialValue) {
        this.variableName = variableName;
        this.initialValue = initialValue;
    }

    @Override
    public String toString() {
        // Implement your logic here
        return "var " + variableName + " = " + initialValue.toString();
    }

    @Override
public Object eval() {
    Object value = initialValue.eval();
   // reste de la logique
    return value; // Return the initial value of the variable
}

}
