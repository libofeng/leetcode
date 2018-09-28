package com.leetcode.array;

public class No48RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int level = 0;
        while (level < n / 2) {
            for (int i = 0; i < n - 2 * level - 1; i++) {
                int temp = matrix[level][level + i];

                //move left to top
                matrix[level][level + i] = matrix[n - level - i - 1][level];

                //move bottom to left
                matrix[n - level - i - 1][level] = matrix[n - level - 1][n - level - i - 1];

                // move right to bottom
                matrix[n - level - 1][n - level - i - 1] = matrix[level + i][n - level - 1];

                // move temp(top) to right
                matrix[level + i][n - level - 1] = temp;
            }

            level++;
        }
    }

    // by using flipping
    public void rotate2(int[][] matrix) {
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - j - 1, n - i - 1);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int p, int q) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }
}
