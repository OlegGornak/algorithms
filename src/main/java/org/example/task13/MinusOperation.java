package org.example.task13;

import java.util.function.BinaryOperator;

class MinusOperation implements BinaryOperator<Integer>, Operation {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public String getType() {
        return "-";
    }
}
