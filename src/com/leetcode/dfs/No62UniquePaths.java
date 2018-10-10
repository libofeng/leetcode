package com.leetcode.dfs;

public class No62UniquePaths {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, new int[m + 1][n + 1]);
    }

    private int dfs(int m, int n, int[][] cache) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        if (cache[m][n] > 0) return cache[m][n];

        return cache[m][n] = dfs(m - 1, n, cache) + dfs(m, n - 1, cache);
    }

    public int uniquePaths2(int m, int n) {
        final int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + dp[j];
        return dp[n - 1];
    }

}
