package calculator4.operators;

public interface Operator<T> {
    Number calculate(T t1, T t2);
}
