package ast;

public class ASTLoop extends ASTexpression {
    private ASTexpression condition;
    private ASTexpression body;

    public ASTLoop(ASTexpression condition, ASTexpression body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toString() {
        // Implement your logic here
        return "while " + condition.toString() + " do " + body.toString();
    }

    @Override
    public Object eval() {
        while (Boolean.TRUE.equals(condition.eval())) {
            body.eval(); // Execute the loop body
        }
        return null; // Loops typically don't return a value
    }

}
