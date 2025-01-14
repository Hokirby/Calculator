package calculator4.operators;

import calculator4.exceptions.InvalidOperationException;

public class OperatorFactory {
    public static <T extends Number> Operator<T> operate(OperatorType type) {
        return switch (type) {
            case PLUS -> new AddOperator<>();
            case MINUS -> new SubtractOperator<>();
            case MULTIPLY -> new MultiplyOperator<>();
            case DIVIDE -> new DivideOperator<>();
            default -> throw new InvalidOperationException();
        };
    }
}