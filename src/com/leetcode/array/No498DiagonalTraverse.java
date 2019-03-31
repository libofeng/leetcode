package com.leetcode.array;

public class No498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int row = 0, col = 0, dir = 1, index = 0;
        final int[] result = new int[m * n];
        while (index < m * n) {
            result[index++] = matrix[row][col];

            row += dir * -1;
            col += dir;

            if (row < 0 || row >= m || col < 0 || col >= n) {
                dir = -dir;

                if (row >= m) {
                    row = m - 1;
                    col += 2;
                } else if (col >= n) {
                    col = n - 1;
                    row += 2;
                } else if (row < 0) {
                    row = 0;
                } else if (col < 0) col = 0;
            }
        }

        return result;
    }
}
