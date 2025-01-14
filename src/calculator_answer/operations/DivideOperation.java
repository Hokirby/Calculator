package calculator_answer.operations;

import calculator_answer.NumberUtils;

import java.math.BigDecimal;

public class DivideOperation<T extends Number> implements Operation<T> {
    @Override
    public T apply(T t1, T t2, Class<T> type) {
        BigDecimal divider = NumberUtils.convertToBigDecimal(t2);
        if (BigDecimal.ZERO.compareTo(divider) == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모가 0일 수 없습니다.");
        }
        BigDecimal divide = NumberUtils.convertToBigDecimal(t1).divide(divider);
        return NumberUtils.castToType(divide, type);
    }
}
