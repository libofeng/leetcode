package com.leetcode.contest.contest136;

public class No1043PartitionArrayForMaximumSum {
    // Idea: array + max/min -> DP
    public int maxSumAfterPartitioning(int[] A, int K) {
        final int n = A.length;
        final long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= K && i - j >= 0; j++) {
                max = Math.max(max, A[i - j]);
                dp[i] = Math.max(dp[i], (long) (max * j) + dp[i - j]);
            }
        }

        return (int) dp[n];
    }
}
