// 팩토리 방식 적용해봄

//package calculator4.Calculators;
//
//import calculator4.Operators.OperatorType;
//
//abstract class AbstractFactory {
//
//    final ArithmeticCalculator createOperation(String num1, String num2, OperatorType operatorType) {
//        ArithmeticCalculator calc1 = createCalculator(String num1);
//        ArithmeticCalculator calc2 = createCalculator(String num2);
//        return operatorType.calculate(calc1, calc2);
//    }
//
//    abstract protected ArithmeticCalculator createCalculator(String number);
//}
//
//class LongCalculatorFactory extends AbstractFactory {
//    @Override
//    protected ArithmeticCalculator createCalculator(String number) {
//        return new LongCalculator(Long.parseLong(number));
//    }
//}
//
//class DoubleCalculatorFactory extends AbstractFactory {
//    @Override
//    protected ArithmeticCalculator createCalculator(String number) {
//        return new DoubleCalculator(Double.parseDouble(number));
//    }
//}

