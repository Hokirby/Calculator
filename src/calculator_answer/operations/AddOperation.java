package calculator_answer.operations;

import calculator_answer.NumberUtils;
import java.math.BigDecimal;

public class AddOperation<T extends Number> implements Operation<T> {

    @Override
    public T apply(T t1, T t2, Class<T> type) {
        BigDecimal adder = NumberUtils.convertToBigDecimal(t2);
        BigDecimal add = NumberUtils.convertToBigDecimal(t1).add(adder);
        return NumberUtils.castToType(add, type);
    }
}
