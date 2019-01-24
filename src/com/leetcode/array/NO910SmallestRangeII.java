package com.leetcode.array;

import java.util.Arrays;

public class NO910SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        if (A.length <= 1) return 0;
        Arrays.sort(A);

        int n = A.length, minDiff = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(A[0] + K, A[i + 1] - K);
            int max = Math.max(A[i] + K, A[n - 1] - K);
            minDiff = Math.min(minDiff, max - min);
        }
        return minDiff;
    }
}
