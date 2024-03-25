package ast;


//import environment.Environment;

public class ASTPrint extends ASTexpression {
    private ASTexpression expression;

    public ASTPrint(ASTexpression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        // Retourne une représentation textuelle de l'opération print
        return "print(" + expression.toString() + ")";
    }

    @Override
    public Object eval(/*Environment env*/) {
        Object value = expression.eval();
        System.out.println(value);
        return value; // Ou retournez null si l'opération print ne doit pas retourner de valeur
    }
}
