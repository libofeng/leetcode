package com.leetcode.dp;

public class No174DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        return helper(dungeon, 0, 0);
    }

    private int helper(int[][] grid, int row, int col) {
        final int m = grid.length, n = grid[0].length;

        if (row == m - 1 && col == n - 1) return Math.max(1, 1 - grid[row][col]);
        if (row == m - 1) return Math.max(1, helper(grid, row, col + 1) - grid[row][col]);
        if (col == n - 1) return Math.max(1, helper(grid, row + 1, col) - grid[row][col]);

        return Math.max(1, Math.min(helper(grid, row + 1, col), helper(grid, row, col + 1)) - grid[row][col]);
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        final int m = dungeon.length, n = dungeon[0].length;
        final int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1] + 1);
        for (int i = m - 2; i >= 0; i--) dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int j = n - 2; j >= 0; j--) dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
