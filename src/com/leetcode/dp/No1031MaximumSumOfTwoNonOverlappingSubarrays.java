package com.leetcode.dp;

public class No1031MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(maxSum(A, L, M), maxSum(A, M, L));
    }

    private int maxSum(int[] A, int L, int M) {
        final int n = A.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + A[i - 1];

        int[] left = new int[n], right = new int[n];

        int leftMax = 0;
        for (int i = L; i < n; i++) {
            int sum = sums[i] - sums[i - L];
            if (sum > leftMax) {
                left[i] = sum;
                leftMax = sum;
            } else left[i] = left[i - 1];
        }

        int rightMax = 0;
        for (int i = n - M; i >= 0; i--) {
            int sum = sums[i + M] - sums[i];
            if (sum > rightMax) {
                right[i] = sum;
                rightMax = sum;
            } else right[i] = right[i + 1];
        }

        int max = 0;
        for (int i = L; i <= n - M; i++) max = Math.max(max, left[i] + right[i]);

        return max;
    }
}
