package calculator4.Operators;

public class AddOperator<T extends Number> implements Operator<T> {
    @Override
    public Number calculate(T t1, T t2) {
        return t1.doubleValue() + t2.doubleValue();
    }
}