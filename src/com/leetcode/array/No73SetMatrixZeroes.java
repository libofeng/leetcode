package com.leetcode.array;

import java.util.Arrays;

public class No73SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false, columnZero = false;
        for (int j = 0; j < matrix[0].length; j++) rowZero = rowZero || matrix[0][j] == 0;
        for (int[] aMatrix : matrix) columnZero = columnZero || aMatrix[0] == 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        if (columnZero) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }

    public void setZeroes2(int[][] matrix) {
        final int m = matrix.length, n = matrix[0].length;
        boolean rowZero = Arrays.stream(matrix[0]).anyMatch(k -> k == 0);
        boolean colZero = Arrays.stream(matrix).anyMatch(k -> k[0] == 0);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
        }

        if (rowZero) Arrays.fill(matrix[0], 0);
        if (colZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}
