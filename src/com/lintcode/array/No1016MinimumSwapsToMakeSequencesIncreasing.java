package com.lintcode.array;

import java.util.Arrays;

public class No1016MinimumSwapsToMakeSequencesIncreasing {
    /**
     * @param A: an array
     * @param B: an array
     * @return: the minimum number of swaps to make both sequences strictly increasing
     */
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; ++i) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.min(1 + dp[i - 1][1], dp[i][1]);
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i][0]);
                dp[i][1] = Math.min(1 + dp[i - 1][0], dp[i][1]);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
