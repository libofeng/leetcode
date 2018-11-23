package com.lintcode.array;

public class No1464TheKthCombination {
    /**
     * @param n: The integer n
     * @param k: The integer k
     * @return: Return the combination
     */
    public int[] getCombination(int n, int k) {
        final int[] R = new int[n / 2];
        helper(n, k, R, 0, 1);
        return R;
    }

    private int count = 0;

    private void helper(int N, int K, int[] R, int i, int start) {
        if (i == R.length) {
            count++;
            return;
        }

        for (int n = start; n <= N && count < K; n++) helper(N, K, R, i + 1, (R[i] = n) + 1);
    }
}
