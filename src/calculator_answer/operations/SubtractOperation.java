package calculator_answer.operations;

import calculator_answer.NumberUtils;

import java.math.BigDecimal;

public class SubtractOperation<T extends Number> implements Operation<T> {
    @Override
    public T apply(T t1, T t2, Class<T> type) {
        BigDecimal subtracter = NumberUtils.convertToBigDecimal(t2);
        BigDecimal subtract = NumberUtils.convertToBigDecimal(t1).add(subtracter);
        return NumberUtils.castToType(subtract, type);
    }
}
