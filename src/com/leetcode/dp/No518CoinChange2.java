package com.leetcode.dp;

public class No518CoinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;

        final int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = 1; i < dp.length; i++) if (i - c >= 0) dp[i] += dp[i - c];
        }

        return dp[amount];
    }

    // 扩展思考：将上述代码中的循环顺序对调，即为求不同硬币的排列数（Permutation）
    // This is NOT the answer
    public int change2(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;

        final int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int c : coins) if (i - c >= 0) dp[i] += dp[i - c];
        }

        return dp[amount];
    }

}
