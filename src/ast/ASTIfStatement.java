package ast;

import environment.Environment;

public class ASTIfStatement extends ASTexpression {
    private ASTexpression condition;
    private ASTexpression thenBranch;
    private ASTexpression elseBranch; // Peut être null

    public ASTIfStatement(ASTexpression condition, ASTexpression thenBranch, ASTexpression elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        String elseString = elseBranch != null ? " else " + elseBranch.toString() : "";
        return "if " + condition.toString() + " then " + thenBranch.toString() + elseString;
    }


    @Override
    public Object eval(Environment env) {
        Object conditionResult = condition.eval(env);
        if (Boolean.TRUE.equals(conditionResult)) {
            return thenBranch.eval(env);
        } else if (elseBranch != null) {
            return elseBranch.eval(env);
        }
        return null; // Aucune branche à exécuter
    }
}
