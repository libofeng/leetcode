package com.leetcode.dp;

import java.util.Arrays;

public class No801MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        final int n = A.length;
        final int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            // Attention: these are 2 separated IF statement.
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }

            if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
