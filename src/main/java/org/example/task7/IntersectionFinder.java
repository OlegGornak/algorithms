package org.example.task7;

import java.util.HashSet;
import java.util.Set;

public class IntersectionFinder {
    public Set<String> findIntersections(String strH, String strV) {
        var matrix = getMatrix(strH, strV);
        var collections = new HashSet<String>();
        getIntersections(strH, strV, matrix, collections, strV.length(), strH.length(), "");
        return collections;
    }

    private void getIntersections(String strH, String strV, int[][] matrix, Set<String> collections,
                                  int i, int j, String current) {
        if (i == 0 || j == 0) {
            collections.add(new StringBuilder(current).reverse().toString());
        } else {
            if (strV.charAt(i - 1) == strH.charAt(j - 1)) {
                current = current + strV.charAt(i - 1);
                getIntersections(strH, strV, matrix, collections, i - 1, j - 1, current);
            } else {
                if (matrix[i - 1][j] == matrix[i][j]) {
                    getIntersections(strH, strV, matrix, collections, i - 1, j, current);
                }

                if (matrix[i][j - 1] == matrix[i][j]) {
                    getIntersections(strH, strV, matrix, collections, i, j - 1, current);
                }
            }
        }
    }

    private int[][] getMatrix(String strH, String strV) {
        var matrix = new int[strV.length() + 1][strH.length() + 1];
        var charsH = strH.toCharArray();
        var charsV = strV.toCharArray();
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (charsH[j - 1] == charsV[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix;
    }
}
