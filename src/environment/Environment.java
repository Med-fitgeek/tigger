package environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Environment {
    private Stack<Map<String, Object>> variableStack = new Stack<>();
    private Map<String, Function> functions = new HashMap<>();

    public Environment() {
        // Push the global scope
        variableStack.push(new HashMap<>());
    }

    // Variable management
    public void declareVariable(String name, Object value) {
        variableStack.peek().put(name, value);
    }

    public Object getVariable(String name) {
        for (int i = variableStack.size() - 1; i >= 0; i--) {
            Map<String, Object> scope = variableStack.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new RuntimeException("Variable not found: " + name);
    }

    public void updateVariable(String name, Object value) {
        for (int i = variableStack.size() - 1; i >= 0; i--) {
            Map<String, Object> scope = variableStack.get(i);
            if (scope.containsKey(name)) {
                scope.put(name, value);
                return;
            }
        }
        throw new RuntimeException("Variable not found: " + name);
    }

    // Function management
    public void defineFunction(String name, Function function) {
        functions.put(name, function);
    }

    public Function getFunction(String name) {
        if (functions.containsKey(name)) {
            return functions.get(name);
        }
        throw new RuntimeException("Function not found: " + name);
    }

    // Scope management
    public void pushScope() {
        variableStack.push(new HashMap<>());
    }

    public void popScope() {
        variableStack.pop();
    }
}

