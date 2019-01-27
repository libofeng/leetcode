package com.leetcode.dp;

public class No983MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        final int n = days.length;
        final int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + costs[0];
            for (int j = i - 1; j >= 0; j--) {
                if (days[i - 1] - days[j] + 1 <= 7) dp[i] = Math.min(dp[i], dp[j] + costs[1]);
                if (days[i - 1] - days[j] + 1 <= 30) dp[i] = Math.min(dp[i], dp[j] + costs[2]);
            }
        }

        return dp[n];
    }
}
