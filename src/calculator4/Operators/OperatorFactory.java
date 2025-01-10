package calculator4.Operators;

import calculator4.Exceptions.InvalidOperationException;

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