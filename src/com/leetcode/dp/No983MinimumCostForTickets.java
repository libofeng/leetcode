package com.leetcode.dp;

import java.util.Arrays;

public class No983MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + costs[0];
            for (int j = i - 1; j >= 0; j--) {
                if (days[i - 1] - days[j] + 1 <= 7) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[1]);
                }
                if (days[i - 1] - days[j] + 1 <= 30) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[2]);
                }
            }
        }
        return dp[n];
    }
}
