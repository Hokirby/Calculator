package calculator_answer.operations;

public interface Operation<T> {
    T apply(T t1, T t2, Class<T> type);
}
