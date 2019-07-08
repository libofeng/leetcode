package com.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class No1027LongestArithmeticSequence {
    // Time: O(N^3), Space: O(1)
    public int longestArithSeqLength(int[] A) {
        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int len = 2, diff = A[j] - A[i], prev = A[j];

                for (int k = j + 1; k < A.length; k++) {
                    if (A[k] != prev + diff) continue;

                    prev = A[k];
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    // DP
    // Time: O(N^2), Space: O(N)
    public int longestArithSeqLength2(int[] A) {
        final int n = A.length;
        if (n <= 1) return n;

        final Map<Integer, Integer>[] dp = new Map[n];

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);

                maxLen = Math.max(maxLen, dp[i].get(diff));
            }
        }

        return maxLen;
    }
}
