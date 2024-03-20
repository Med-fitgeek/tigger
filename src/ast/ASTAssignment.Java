package ast;

public class ASTAssignment extends ASTexpression {
    private String variableName;
    private ASTexpression newValue;

    public ASTAssignment(String variableName, ASTexpression newValue) {
        this.variableName = variableName;
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        // Implement your logic here
        return variableName + " = " + newValue.toString();
    }

    @Override
    public Object eval(Environment env) {
        // Implement assignment logic here, including value update
        return null;
    }
}
