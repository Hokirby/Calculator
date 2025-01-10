package calculator4.Calculators;

public interface ArithmeticCalculator<T> {
    T add(T other);
    T subtract(T other);
    T multiply(T other);
    T divide(T other);
}
