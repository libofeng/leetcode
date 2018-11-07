package com.lintcode.math;

import java.util.Arrays;

public class No896PrimeProduct {
    /**
     * @param arr: The prime array
     * @return: Return the array of all of prime product
     */
    public int[] getPrimeProduct(int[] arr) {
        int count = (int) Math.pow(2, arr.length) - 1 - arr.length;
        final int[] R = new int[count];
        helper(arr, R, 1, 0, 0);

        Arrays.sort(R);
        return R;
    }

    private int p = 0;

    private void helper(int[] A, int[] R, int num, int level, int start) {
        if (level > 1) R[p++] = num;
        for (int i = start; i < A.length; i++) helper(A, R, num * A[i], level + 1, i + 1);
    }
}
