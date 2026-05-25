package org.example.task13;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

//Model
public class CalculatorModel {
    private final Map<String, BinaryOperator<Integer>> operationMap = new HashMap<>();
    private int result;
    private Consumer<Integer> onResultChangedListener;

    public void registerOperation(String name, BinaryOperator<Integer> operation) {
        operationMap.put(name, operation);
    }

    public void setOnResultChangedListener(Consumer<Integer> listener) {
        this.onResultChangedListener = listener;
    }

    public void execute(int a, int b, String name) {
        BinaryOperator<Integer> operation = operationMap.get(name);
        if (operation == null) {
            throw new IllegalArgumentException("Операция не найдена: " + name);
        }

        this.result = operation.apply(a, b);

        if (onResultChangedListener != null) {
            onResultChangedListener.accept(result);
        }
    }
}
