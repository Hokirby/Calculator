package calculator4;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorType {
    PLUS("+"){
        @Override
        public <Calc extends ArithmeticCalculator<Calc>> Calc calculate(Calc calc1, Calc calc2) {
            if (!(calc1 instanceof calc2.getClass())){
                calc1 = new DoubleCalculator(Double.parseDouble(calc1.toString()));
                Object.getClass()

            }
            return calc1.add(calc2);
        }
    },
    MINUS("-") {
        @Override
        public <Calc extends ArithmeticCalculator<Calc>> Calc calculate(Calc calc1, Calc calc2) {
            return calc1.subtract(calc2);
        }
    },
    Multiply("*"){
        public <Calc extends ArithmeticCalculator<Calc>> Calc calculate(Calc calc1, Calc calc2) {
            return calc1.multiply(calc2);
        }
    },
    Divide("/"){
        public <Calc extends ArithmeticCalculator<Calc>> Calc calculate(Calc calc1, Calc calc2) {
            return calc1.divide(calc2);
        }
    };

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static Optional<OperatorType> getOperator(String signInput) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.symbol.equals(signInput))
                .findFirst();
    }

    public abstract <Calc extends ArithmeticCalculator<Calc>> Calc calculate(Calc calc1, Calc calc2);
}
