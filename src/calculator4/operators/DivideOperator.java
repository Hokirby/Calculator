package calculator4.operators;

import calculator4.exceptions.*;

public class DivideOperator<T extends Number> implements Operator<T> {
    @Override
    public Number calculate(T t1, T t2) {
        if (t2.doubleValue() == 0) {
            throw new ZeroDivisionException();
        }
        return t1.doubleValue() / t2.doubleValue();
    }
}
