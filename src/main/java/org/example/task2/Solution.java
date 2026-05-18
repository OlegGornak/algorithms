package org.example.task2;

import java.util.List;

public class Solution {
    public static Result findMinMaxCompact(List<Integer> lst) {
        int min, max;
        int i;

        if (lst.size() % 2 != 0) {
            min = lst.get(0);
            max = lst.get(0);
            i = 1;
        } else {
            if (lst.get(0) < lst.get(1)) {
                min = lst.get(0);
                max = lst.get(1);
            } else {
                min = lst.get(1);
                max = lst.get(0);
            }
            i = 2;
        }

        for (; i < lst.size() - 1; i += 2) {
            if (lst.get(i) < lst.get(i + 1)) {
                if (lst.get(i) < min)
                    min = lst.get(i);
                if (lst.get(i + 1) > max)
                    max = lst.get(i + 1);
            } else {
                if (lst.get(i + 1) < min)
                    min = lst.get(i + 1);
                if (lst.get(i) > max)
                    max = lst.get(i);
            }
        }
        return new Result(min,max);
    }
}
