package calculator4;

public class DoubleCalculator implements ArithmeticCalculator<DoubleCalculator> {
    private final double number;

    public DoubleCalculator(double number){
        this.number = number;
    }

    @Override
    public DoubleCalculator add(DoubleCalculator other) {
        return new DoubleCalculator(this.number + other.number);
    }

    @Override
    public DoubleCalculator subtract(DoubleCalculator other) {
        return new DoubleCalculator(this.number - other.number);
    }

    @Override
    public DoubleCalculator multiply(DoubleCalculator other) {
        return new DoubleCalculator(this.number * other.number);
    }

    @Override
    public DoubleCalculator divide(DoubleCalculator other) {
        return new DoubleCalculator(this.number/ other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
