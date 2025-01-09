package calculator4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GenericCalculator {
    private List<? extends ArithmeticCalculator> results = new ArrayList<>();

    public boolean isDigit(String number) {
        return (number.chars().allMatch(Character::isDigit));
    }

    public boolean isLong(String number) {
        return !Arrays.asList(number.split("")).contains(".");
    }

    public ArithmeticCalculator getCalc(String number) {
        if (isLong(number)) {
            return new LongCalculator(Long.parseLong(number));
        } else {
            return new DoubleCalculator(Double.parseDouble(number));
        }
    }

    public <Calc extends ArithmeticCalculator<Calc>> Optional<Calc> calculate(Calc calc1, Calc calc2, OperatorType
            operator) {
        return Optional.of(operator.calculate(calc1, calc2));
    }


    public<T extends ArithmeticCalculator> void addResult(T result) {
        this.results.add(result);
    }

    public List<? extends ArithmeticCalculator> getResults() {
        return results;
    }
}
