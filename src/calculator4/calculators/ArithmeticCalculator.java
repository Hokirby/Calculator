package calculator4.calculators;

public interface ArithmeticCalculator<T> {
    T add(T other);
    T subtract(T other);
    T multiply(T other);
    T divide(T other);
}
