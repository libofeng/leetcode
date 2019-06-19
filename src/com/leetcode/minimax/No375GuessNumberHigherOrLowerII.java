package com.leetcode.minimax;

public class No375GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        final int[][] dp = new int[n + 1][n + 1];
        return dfs(dp, 1, n);
    }

    private int dfs(int[][] dp, int start, int end) {
        if (end <= start) return 0;
        if (dp[start][end] > 0) return dp[start][end];

        int min = Integer.MAX_VALUE;
        for (int k = start; k <= end; k++) {
            min = Math.min(min, k + Math.max(dfs(dp, start, k - 1), dfs(dp, k + 1, end)));
        }

        dp[start][end] = min;
        return min;
    }
}
