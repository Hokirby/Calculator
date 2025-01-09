package calculator4;

import calculator3.ZeroDivisionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class GenericCalculator {
    ArrayList<ArithmeticCalculator> results = new ArrayList<>();

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
        try {
            return Optional.of(operator.calculate(calc1, calc2));
        } catch (ZeroDivisionException e) {
            return Optional.empty();
        }
    }

    public void addResult(ArithmeticCalculator result) {
        this.results.add(result);
    }

    public ArrayList<ArithmeticCalculator> getResults() {
        return results;
    }
}
