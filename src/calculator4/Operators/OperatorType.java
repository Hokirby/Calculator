package calculator4.Operators;

import java.util.Optional;
import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static Optional<OperatorType> getOperator(String signInput) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.symbol.equals(signInput))
                .findFirst();
    }


}