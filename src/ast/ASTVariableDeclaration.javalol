package ast;

import environment.Environment;

public class ASTVariableDeclaration extends ASTexpression {
    private String variableName;
    private ASTexpression initialValue;

    public ASTVariableDeclaration(String variableName, ASTexpression initialValue) {
        this.variableName = variableName;
        this.initialValue = initialValue;
    }

    @Override
    public String toString() {
        return "var " + variableName + " = " + initialValue.toString();
    }


    @Override
    public Object eval(Environment env) {
        Object value = initialValue.eval(env);
        env.declareVariable(variableName, value);
        return value;
    }
}
