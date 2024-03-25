package ast;

import java.math.BigInteger;
//import environment.Environment;

public class ASTbinaryOperation extends ASTexpression {

    private final String operator;
    private final ASTexpression leftOperand;
    private final ASTexpression rightOperand;

    public ASTbinaryOperation(String operator, ASTexpression leftOperand, ASTexpression rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public ASTexpression getLeftOperand() {
        return leftOperand;
    }

    public ASTexpression getRightOperand() {
        return rightOperand;
    }

    @Override
    public String toString() {
        // Retourne une représentation sous forme de chaîne de l'opération binaire
        return "(" + leftOperand.toString() + " " + operator + " " + rightOperand.toString() + ")";
    }

    @Override
    public Object eval(/*Environment env*/) {
        // Évalue les opérandes
        Object leftValue = leftOperand.eval();
        Object rightValue = rightOperand.eval();

        // Assurez-vous que les opérandes sont des BigInteger
        if (!(leftValue instanceof BigInteger) || !(rightValue instanceof BigInteger)) {
            throw new IllegalArgumentException("Unsupported operand types for binary operation");
        }

        BigInteger left = (BigInteger) leftValue;
        BigInteger right = (BigInteger) rightValue;

        // Applique l'opération binaire en fonction de l'opérateur
        switch (operator) {
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            case "*":
                return left.multiply(right);
            case "/":
                if (right.equals(BigInteger.ZERO)) {
                    throw new ArithmeticException("Division by zero");
                }
                return left.divide(right);
            // Ajoutez d'autres cas ici pour d'autres opérations binaires
            default:
                throw new UnsupportedOperationException("Unsupported binary operator: " + operator);
        }
    }
}
