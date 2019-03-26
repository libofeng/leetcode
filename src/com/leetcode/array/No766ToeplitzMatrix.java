package com.leetcode.array;

public class No766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
        }
        return true;
    }
}
