package calculator4.calculators;

import calculator4.exceptions.ZeroDivisionException;

public class LongCalculator implements ArithmeticCalculator<LongCalculator> {
    private long number;

    public LongCalculator(long number) {
        this.number = number;
    }

    public LongCalculator setNumber(long number){
        this.number = number;
        return this;
    }

    @Override
    public LongCalculator add(LongCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public LongCalculator subtract(LongCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public LongCalculator multiply(LongCalculator other) {
        return this.setNumber(this.number + other.number);
    }

    @Override
    public LongCalculator divide(LongCalculator other) {
        if (other.number == 0){
            throw new ZeroDivisionException();
        }
        return this.setNumber(this.number + other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
