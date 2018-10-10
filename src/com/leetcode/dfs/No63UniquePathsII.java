package com.leetcode.dfs;

public class No63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) return 0;

        final int[][] cache = new int[rows + 1][cols + 1];
        return dfs(obstacleGrid, cache, rows, cols);
    }

    private int dfs(int[][] obstacleGrid, int[][] cache, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        if (cache[m][n] > 0) return cache[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        return cache[m][n] = dfs(obstacleGrid, cache, m - 1, n) + dfs(obstacleGrid, cache, m, n - 1);
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        final int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) return 0;

        final int[] dp = new int[cols];
        dp[0] = 1;
        for (int i = 0; i < rows; i++) {
            dp[0] = dp[0] == 0 ? 0 : (obstacleGrid[i][0] == 1 ? 0 : 1);
            for (int j = 1; j < cols; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : (dp[j] + dp[j - 1]);
            }
        }

        return dp[cols - 1];
    }
}
