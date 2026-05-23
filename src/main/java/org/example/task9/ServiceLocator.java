package org.example.task9;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ServiceLocator {
    private final Supplier<Model> supplier;
    private final Consumer<Model> consumer;
    private final Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public ServiceLocator(Supplier<Model> supplier, Consumer<Model> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    public Supplier<Model> getSupplier() {
        return supplier;
    }

    public Consumer<Model> getConsumer() {
        return consumer;
    }

    public BinaryOperator<Integer> getOperation(String op) {
        return operations.get(op);
    }

    public void add(Object obj) {
        switch (obj) {
            case Operation operation -> operations.put(operation.getType(), (BinaryOperator<Integer>) operation);
            case null, default -> throw new IllegalArgumentException();
        }
    }
}
