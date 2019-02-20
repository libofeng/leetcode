package com.leetcode.dfs;

public class No62UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePaths2(int m, int n) {
        return dfs(m, n, new int[m + 1][n + 1]);
    }

    private int dfs(int m, int n, int[][] cache) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        if (cache[m][n] > 0) return cache[m][n];

        return cache[m][n] = dfs(m - 1, n, cache) + dfs(m, n - 1, cache);
    }

    // dp[i][j] = dp[i-1] + dp[i][j-1]
    // dp[1][j] = 1;
    // dp[i][1] = 1;
    public int uniquePaths3(int m, int n) {
        final int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][1] = 1;
        for (int j = 1; j <= n; j++) dp[1][j] = 1;

        for (int i = 2; i <= m; i++) for (int j = 2; j <= n; j++) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m][n];
    }

    public int uniquePaths4(int m, int n) {
        final int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++) dp[j] += dp[j - 1];
        return dp[n];
    }

}
