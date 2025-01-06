package calculator3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calc = new ArithmeticCalculator();
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                calc.setNum1(sc.nextDouble());
                System.out.print("두 번째 숫자를 입력하세요: ");
                calc.setNum2(sc.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                sc.nextLine();
                continue;
            }
            try{
            System.out.print("사칙연산 기호를 입력하세요: ");
            String signInput = sc.next();
            OperatorType operatorType = OperatorType.getOperator(signInput);
            Optional<Number> result = calc.calculate(calc.getNum1(), calc.getNum2(), operatorType);
            if (result.isEmpty()) {
                System.out.println("Invalid Result");
            } else {
                System.out.println("결과: " + result.get());
                calc.addResult(result.get());
            }
            } catch (ZeroDivisionException e) {
                System.out.println(e.message);
                continue;
            } catch (OperatorNotFoundException e) {
                System.out.println(e.message);
                continue;
            }
            System.out.println("연산 결과값: " + calc.getResults().toString());
            System.out.println("입력값보다 큰 연산결과값을 조회합니다 기준값을 입력하세요: ");
            Double num3 = sc.nextDouble();
            List<Number> biggerList = calc.getBiggerList(num3);
            System.out.println(biggerList.toString());
            System.out.print("종료를 원하시면 'exit' 를, 추가 계산을 원하시면 다른 키를 입력하세요 ");
            if (sc.next().equalsIgnoreCase("exit")) {
                System.exit(1);
            }
        }
    }

}
