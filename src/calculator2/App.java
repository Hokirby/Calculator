package calculator2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        int maxResultCount = 3;
        int curResultCount = 0;
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                calc.setNum1(sc.nextInt());
                System.out.print("두 번째 숫자를 입력하세요: ");
                calc.setNum2(sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("입력값의 정보가 잘못되었습니다.");
                sc.nextLine();
                continue;
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            String sign = sc.next();
            if (calc.calculate(calc.getNum1(), calc.getNum2(), sign).isEmpty()) {
                System.out.println("결과값이 없습니다");
            } else {
                int answer = calc.calculate(calc.getNum1(), calc.getNum2(), sign).get();
                System.out.println("결과: " + answer);
                calc.addResult(answer);
                curResultCount++;
            }
            if (maxResultCount < curResultCount) {
                System.out.println("최대 저장개수 초과하여 최초저장값을 삭제합니다.");
                calc.removeResult();
            }
            System.out.println("현재 저장된 결과값: " + calc.getResults());
            System.out.print("종료를 원하시면 'exit' 를, 추가 계산을 원하시면 다른 키를 입력하세요 ");
            if (sc.next().equalsIgnoreCase("exit")) {
                System.exit(1);
            }
        }
    }
}
