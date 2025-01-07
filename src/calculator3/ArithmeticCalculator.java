package calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator {
    double num1;
    double num2;
    private ArrayList<Double> results = new ArrayList<>();

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

    public ArrayList<Double> getResults() {
        return this.results;
    }


    public void addResult(Double result) {
        this.results.add(result);
    }

    public List<Double> getBiggerList(Double num3) {
        return this.results.stream()
                .filter(num -> num3 < num)
                .toList();
    }

    public Double getResult(int index) {
        return this.results.get(index);
    }

    public Double absolute(Double result) {
        return Math.abs(result);
    }

    public Optional<Double> round(Double result) {
        if (result % 1 != 0) {
            return Optional.of((double) Math.round(result * 10) / 10);
        } else {
            return Optional.empty();
        }
    }

    public void replaceResult(int index, Double result) {
        results.set(index, result);
    }

    public <T extends Number> Optional<Double> calculate(T num1, T num2, OperatorType operator) {
        try {
            return Optional.of(operator.calculate(num1, num2));
        } catch (ZeroDivisionException e) {
            return Optional.empty();
        }
    }

}
