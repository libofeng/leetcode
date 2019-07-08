package com.leetcode.math;

public class No1027LongestArithmeticSequence {
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
}
