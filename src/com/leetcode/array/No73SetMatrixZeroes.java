package com.leetcode.array;

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
}
