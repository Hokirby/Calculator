package calculator_answer;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    private final ArrayList<T> resultList = new ArrayList<>();
    private final Class<T> type;

    public ArithmeticCalculator(Class<T> type) {
        this.type = type;
    }

    public T calculate(T num1, T num2, Operator operator){
        T result = operator.apply(num1, num2, type);
        resultList.add(result);
        return result;
    }

    public List<T> getBiggerList(T value) {
        return resultList.stream()
                .filter(result -> NumberUtils.convertToBigDecimal(value).compareTo(NumberUtils.convertToBigDecimal(result)) > 0)
                .toList();
    }

    public void addResult(T result) {
        resultList.add(result);
    }
}
