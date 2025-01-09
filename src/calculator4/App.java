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
            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/,^): ");
            String signInput = sc.next();
            Optional<OperatorType> operatorType = OperatorType.getOperator(signInput);
            if (operatorType.isEmpty()) {
                System.out.println("Invalid Input");
                continue;
            }

            if(gc.getCalc(num1)== gc.getCalc(num2)){
                //TODO num1, num2의 타입이 다를 경우 타입 일치 시켜주면 됨, 끝.
                //TODO num1이 1이고 num2 3.3일 경우 기획 의도에 맞게 num을 1.0으로 만들어주든 num2를 3으로 만들어주면 끝임


            }


            //TODO 타입 검사 후 맞는거로 변경한 다음에 gc.calculate에 인자로 넘겨주기
            Optional<ArithmeticCalculator> result = gc.calculate(gc.getCalc(num1), gc.getCalc(num2), operatorType.get());
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
