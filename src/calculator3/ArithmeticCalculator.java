package calculator3;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator {
    double num1;
    double num2;
    private LinkedList<Double> results = new LinkedList<>();

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getNum2() {
        return num2;
    }

    public LinkedList<Double> getResults() {
        return this.results;
    }

    public void removeResult() {
        this.results.poll();
    }

    public void addResult(Double result) {
        this.results.add(result);
    }

    public List<Double> getBiggerList(Double num3) {
        return this.results.stream()
                .filter(num -> num3 < num)
                .toList();
    }

    public <T extends Number> Optional<Double> calculate(T num1, T num2, OperatorType operator) {
        try {
            return Optional.of(operator.calculate(num1, num2));
        } catch (ZeroDivisionException e) {
            return Optional.empty();
        }
    }

}
