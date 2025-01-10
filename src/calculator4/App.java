package calculator4;

import calculator4.Calculators.GenericCalculator;
import calculator4.Exceptions.InvalidOperationException;
import calculator4.Exceptions.ZeroDivisionException;
import calculator4.Operators.OperatorFactory;
import calculator4.Operators.OperatorType;

import java.util.List;
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
            Double result;
            try {
                result = OperatorFactory.operate(operatorType.get()).calculate(Double.parseDouble(num1), Double.parseDouble(num2)).doubleValue();
            } catch (InvalidOperationException | ZeroDivisionException e) {
                System.out.println("Invalid Result");
                continue;
            }
            System.out.println("결과: " + result);
            gc.addResult(result);
            System.out.println("연산 결과값: " + gc.getResults().toString());
            System.out.println("입력값보다 큰 연산결과값을 조회합니다 기준값을 입력하세요: ");
            Double num3 = sc.nextDouble();
            List<Double> biggerList = gc.getBiggerList(num3);
            System.out.println(biggerList.toString());
            System.out.print("종료를 원하시면 'exit' 를, 추가 계산을 원하시면 다른 키를 입력하세요 ");
            if (sc.next().equalsIgnoreCase("exit")) {
                System.exit(0);
            }

        }
    }
}
