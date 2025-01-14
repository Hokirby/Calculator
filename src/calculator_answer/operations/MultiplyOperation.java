package calculator_answer.operations;

import calculator_answer.NumberUtils;

import java.math.BigDecimal;

public class MultiplyOperation<T extends Number> implements Operation<T> {
    @Override
    public T apply(T t1, T t2, Class<T> type) {
        BigDecimal multiplier = NumberUtils.convertToBigDecimal(t2);
        BigDecimal multiply = NumberUtils.convertToBigDecimal(t1).multiply(multiplier);
        return NumberUtils.castToType(multiply,type);
    }
}
