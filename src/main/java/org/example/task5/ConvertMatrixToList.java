package org.example.task5;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrixToList {
    public List<int[]> convert(int[][] arr) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
}
