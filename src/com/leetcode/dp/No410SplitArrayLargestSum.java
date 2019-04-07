package com.leetcode.dp;

import java.util.Arrays;

public class No410SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        final int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    int max = Math.max(dp[i - 1][k], sums[j] - sums[k]);
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }

        return dp[m][n];
    }
}
