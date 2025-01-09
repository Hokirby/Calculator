package calculator4;

import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericCalculator gc = new GenericCalculator();
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String num1 = sc.next();
            if (!gc.isDigit(num1)) {
                System.out.println("Invalid Number");
                continue;
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            String num2 = sc.next();
            if (!gc.isDigit(num2)) {
                System.out.println("Invalid Input");
            }
            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/): ");
            String signInput = sc.next();
            Optional<OperatorType> operatorType = OperatorType.getOperator(signInput);
            if (operatorType.isEmpty()) {
                System.out.println("Invalid Input");
                continue;
            }
            Optional<? extends ArithmeticCalculator> result;
            if((gc.isLong(num1) != gc.isLong(num2))){
                DoubleCalculator doubleCalc1 = new DoubleCalculator(Double.parseDouble(num1));
                DoubleCalculator doubleCalc2 = new DoubleCalculator(Double.parseDouble(num2));
                result = gc.calculate(doubleCalc1, doubleCalc2, operatorType.get());
            }else {
                result = gc.calculate(gc.getCalc(num1), gc.getCalc(num2), operatorType.get());
            }
            if (result.isEmpty()) {
                System.out.println("Invalid Result");
            } else {
                System.out.println("결과: " + result.get());
                gc.addResult(result.get());
            }
            System.out.println("연산 결과값: " + gc.getResults().toString());
            System.out.print("종료를 원하시면 'exit' 를, 추가 계산을 원하시면 다른 키를 입력하세요 ");
            if (sc.next().equalsIgnoreCase("exit")) {
                System.exit(0);
            }

        }
    }
}
