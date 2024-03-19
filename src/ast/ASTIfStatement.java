package ast;

public class ASTIfStatement extends ASTexpression {
    private ASTexpression condition;
    private ASTexpression thenBranch;
    private ASTexpression elseBranch; // Can be null for if statements without an else branch

    public ASTIfStatement(ASTexpression condition, ASTexpression thenBranch, ASTexpression elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        return "if " + condition.toString() + " then " + thenBranch.toString() + 
               (elseBranch != null ? " else " + elseBranch.toString() : "");
    }

    @Override
    public Object eval() {
        Object conditionResult = condition.eval();
        if (Boolean.TRUE.equals(conditionResult)) {
            return thenBranch.eval();
        } else if (elseBranch != null) {
            return elseBranch.eval();
        }
        return null; // No else branch to execute
    }

}
