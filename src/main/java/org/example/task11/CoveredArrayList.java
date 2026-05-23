package org.example.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CoveredArrayList<E> extends ArrayList<E> {
    AtomicInteger counter;

    public CoveredArrayList(List<E> list, AtomicInteger counter) {
        super(list);
        this.counter = counter;
    }

    @Override
    public boolean add(E e) {
        var result = super.add(e);
        counter.incrementAndGet();
        return result;
    }

    @Override
    public void add(int index, E element) {
        super.add(index, element);
        counter.incrementAndGet();
    }
}
