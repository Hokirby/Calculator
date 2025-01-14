package calculator_answer;

import calculator_answer.operations.*;

import java.util.Arrays;

public enum Operator {
    PLUS("+", new AddOperation()),
    MINUS("-", new SubtractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation());

    private final String symbol;
    private final Operation operation;

    Operator(String symbol, Operation operation){
        this.symbol = symbol;
        this.operation = operation;
    }

    public <T extends Number> T apply (T t1, T t2, Class<T> type) {
        return this.apply(t1, t2, type);
    }

    public static Operator getOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow();
    }
}
