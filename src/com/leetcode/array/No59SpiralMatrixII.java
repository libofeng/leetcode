package com.leetcode.array;

public class No59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        final int[][] grid = new int[n][n];
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1, num = 1;
        while (num <= n * n) {
            for (int i = colStart; i <= colEnd; i++) grid[rowStart][i] = num++;
            for (int i = rowStart + 1; i < rowEnd; i++) grid[i][colEnd] = num++;

            if (rowEnd > rowStart) for (int i = colEnd; i >= colStart; i--) grid[rowEnd][i] = num++;
            if (colEnd > colStart) for (int i = rowEnd - 1; i > rowStart; i--) grid[i][colStart] = num++;

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

        return grid;
    }
}
