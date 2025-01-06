package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("입력값의 정보가 잘못되었습니다.");
                sc.nextLine();
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            String sign = sc.next();
            Integer result = 0;
            //boolean isResult = true;//줄일수있으면
            switch (sign) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 수)에 0이 입력될 수 없습니다.");
                        result = null;
                        break;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("기호 정보가 잘못되었습니다.");
                    result = null;
            }
            if (result == null) {
                System.out.println("결과값이 없습니다");
            } else {
                System.out.println("결과: " + result);
            }
            System.out.print("종료를 원하시면 'exit' 를, 추가 계산을 원하시면 다른 키를 입력하세요 ");
            if (sc.next().equalsIgnoreCase("exit")) {
                System.exit(1);
            }
        }
    }
}
