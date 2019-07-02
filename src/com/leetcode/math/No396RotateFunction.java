package com.leetcode.math;

public class No396RotateFunction {
    public int maxRotateFunction(int[] A) {
        final int N = A.length;

        int F = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            F += A[i] * i;
            sum += A[i];
        }

        int maxSum = F;
        for (int i = N - 1; i > 0; i--) {
            F = F + sum - N * A[i];
            maxSum = Math.max(maxSum, F);
        }

        return maxSum;
    }
}
