package com.leetcode.array;

public class No64MinimumPathSum {

    public int minPathSum(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[m - 1][n - 1];
    }
}
