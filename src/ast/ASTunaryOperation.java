package ast;

import java.math.BigInteger;

import environment.Environment;

public class ASTunaryOperation extends ASTexpression {

    private final String operator;
    private final ASTexpression operand;

    public ASTunaryOperation(String operator, ASTexpression operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public ASTexpression getOperand() {
        return operand;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        // Retourne une représentation sous forme de chaîne de l'opération unaire
        return "(" + operator + operand.toString() + ")";
    }

    @Override
    public Object eval(Environment env) {
        // Évalue l'opérande
        Object opValue = operand.eval(env);

        // Assurez-vous que l'opérande est un BigInteger (ou adaptez selon le type attendu)
        if (!(opValue instanceof BigInteger)) {
            throw new IllegalArgumentException("Unsupported operand type for unary operation");
        }

        BigInteger value = (BigInteger) opValue;

        // Applique l'opération unaire en fonction de l'opérateur
        switch (operator) {
            case "-":
                return value.negate();
            // Ajoutez d'autres cas ici pour d'autres opérations unaires
            default:
                throw new UnsupportedOperationException("Unsupported unary operator: " + operator);
        }
    }
}
