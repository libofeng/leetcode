package com.leetcode.dp;

public class No322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = amount, n = coins.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) dp[i][0] = Integer.MAX_VALUE;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - coins[j - 1] >= 0 && dp[i - coins[j - 1]][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - coins[j - 1]][j] + 1);
                } else dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[m][n] == Integer.MAX_VALUE ? -1 : dp[m][n];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
