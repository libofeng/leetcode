package com.leetcode.math;

public class No313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        final int k = primes.length;
        final int[] pointers = new int[k], values = new int[k], ugly = new int[n];
        System.arraycopy(primes, 0, values, 0, k);
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int v : values) min = Math.min(min, v);
            ugly[i] = min;

            for (int j = 0; j < k; j++) {
                if (min != values[j]) continue;
                values[j] = primes[j] * ugly[++pointers[j]];
            }
        }

        return ugly[n - 1];
    }
}
