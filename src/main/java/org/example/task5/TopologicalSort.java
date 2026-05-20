package org.example.task5;

import java.util.LinkedList;

public class TopologicalSort {
    public Integer[] sort(int[][] arr) {
        var queue = new LinkedList<Integer>();
        step(arr, queue, 0);//Начальный шаг

        Integer[] result = new Integer[queue.size()];
        for (int i = 0; i < result.length; i++) {//Меняем порядок элементов
            result[i] = queue.pollLast();
        }
        return result;
    }

    public void step(int[][] arr, LinkedList<Integer> queue, int current) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[current][i] == 1) {
                step(arr, queue, i);//Ветвление из текущего
            }
        }
        queue.add(current);//Сохраняем текущий
    }
}
