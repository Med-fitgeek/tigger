package environment;

@FunctionalInterface
public interface Function {
    Object call(Object... args);
}
