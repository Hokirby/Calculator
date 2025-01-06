package calculator3;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator {
    double num1;
    double num2;
    private LinkedList<Number> results = new LinkedList<>();

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

    public LinkedList<Number> getResults() {
        return this.results;
    }

    public void removeResult() {
        this.results.poll();
    }

    public void addResult(Number result) {
        this.results.add(result);
    }

    public List<Number> getBiggerList(Double num3) {
        return this.results.stream()
                .filter(num -> num3 < num.doubleValue())
                .toList();
    }

    public <T extends Number> Optional<T> calculate(T num1, T num2, OperatorType operator) {
        return Optional.of(operator.calculate(num1, num2));
    }

}
