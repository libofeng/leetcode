package com.lintcode.array;

public class No397LongestContinuousIncreasingSubsequence {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length <= 1) return A.length;
        int max = 1, count = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else count = 1;
        }

        count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else count = 1;
        }

        return max;
    }
}
