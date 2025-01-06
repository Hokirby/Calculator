package calculator3;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+") {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        }
    },

    MINUS("-") {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        }
    },

    MULTIPLE("*") {
        @Override
        public <T extends Number> T calculate(T num1, T num2) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        }
    },

    DIVIDE("/") {
        @Override
        public <T extends Number> T calculate(T num1, T num2) throws RuntimeException {
            if (num2.doubleValue() == 0) {
                throw new ZeroDivisionException();
            }
            return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
        }
    };

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static OperatorType getOperator(String signInput) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.symbol.equals(signInput))
                .findFirst()
                .orElseThrow(() -> new OperatorNotFoundException());
    }

    public abstract <T extends Number> T calculate(T num1, T num2) throws OperatorNotFoundException;
}
