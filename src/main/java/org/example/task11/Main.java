package org.example.task11;

import t1.task.Magic;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        List<Integer> lst = new CoveredArrayList<>(List.of(3,4,5), counter);
        Magic.test(lst);
        System.out.println("count = " + counter.get());
    }
}
