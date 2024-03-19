package ast;

import java.util.List;

public class ASTFunctionCall extends ASTexpression {
    private String functionName;
    private List<ASTexpression> arguments;

    public ASTFunctionCall(String functionName, List<ASTexpression> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        // Implement your logic here
        return functionName + "(" + arguments.stream().map(Object::toString).reduce((a, b) -> a + ", " + b).orElse("") + ")";
    }

        @Override
    public Object eval() {
        Function function = environment.lookupFunction(functionName);
        List<Object> argValues = arguments.stream().map(ASTexpression::eval).collect(Collectors.toList());
        return function.call(argValues); // Assuming you have a call method that executes the function
    }

}
