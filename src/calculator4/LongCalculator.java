package calculator4;

import calculator3.ZeroDivisionException;

public class LongCalculator implements ArithmeticCalculator<LongCalculator> {
    private final long number;

    public LongCalculator(long number) {
        this.number = number;
    }

    @Override
    public LongCalculator add(LongCalculator other) {
        return new LongCalculator(this.number + other.number);
    }

    @Override
    public LongCalculator subtract(LongCalculator other) {
        return new LongCalculator(this.number - other.number);
    }

    @Override
    public LongCalculator multiply(LongCalculator other) {
        return new LongCalculator(this.number * other.number);
    }

    @Override
    public LongCalculator divide(LongCalculator other) {
        if (other.number == 0){
            throw new ZeroDivisionException();
        }
        return new LongCalculator(this.number / other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
