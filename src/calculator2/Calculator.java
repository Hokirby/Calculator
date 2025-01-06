package calculator2;

import java.util.LinkedList;
import java.util.Optional;

public class Calculator {
    private int num1;
    private int num2;
    private final LinkedList<Integer> results = new LinkedList<>();

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    public LinkedList<Integer> getResults() {
        return this.results;
    }

    public void removeResult() {
        this.results.poll();
    }

    public void addResult(Integer result) {
        this.results.add(result);
    }

    public Optional<Integer> calculate(int num1, int num2, String sign) {
        switch (sign) {
            case "+":
                return Optional.of(num1 + num2);
            case "-":
                return Optional.of(num1 - num2);
            case "*":
                return Optional.of(num1 * num2);
            case "/":
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 수)에 0이 입력될 수 없습니다.");
                    return Optional.empty();
                }
                return Optional.of(num1 / num2);
            default:
                System.out.println("기호 정보가 잘못되었습니다.");
                return Optional.empty();
        }
    }
}
