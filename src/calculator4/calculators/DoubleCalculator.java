package calculator4.calculators;

import calculator4.exceptions.ZeroDivisionException;

public class DoubleCalculator implements ArithmeticCalculator<DoubleCalculator> {
    private double number;

    public DoubleCalculator(double number) {
        this.number = number;
    }

    public DoubleCalculator setNumber(double number) {
        this.number = number;
        return this;
    }

    @Override
    public DoubleCalculator add(DoubleCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public DoubleCalculator subtract(DoubleCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public DoubleCalculator multiply(DoubleCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public DoubleCalculator divide(DoubleCalculator other) {
        if (other.number == 0){
            throw new ZeroDivisionException();
        }
        return this.setNumber(this.number + other.number);
    }
}