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

        for (int i = 1; i < n; i++) {
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

    // simplified
    public int minSwap2(int[] A, int[] B) {
        int prevKeep = 0, prevSwap = 1;
        for (int i = 1; i < A.length; i++) {
            int keep = Integer.MAX_VALUE, swap = keep;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                keep = Math.min(keep, prevKeep);
                swap = Math.min(swap, prevSwap + 1);
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                keep = Math.min(keep, prevSwap);
                swap = Math.min(swap, prevKeep + 1);
            }

            prevKeep = keep;
            prevSwap = swap;
        }

        return Math.min(prevKeep, prevSwap);
    }
}
