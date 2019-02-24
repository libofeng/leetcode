package com.leetcode.array;

import java.util.Arrays;

public class No891SumOfSubsequenceWidths {
/*    The order in initial arrays doesn't matter,
    my first intuition is to sort the array.

    For A[i]:
    There are i smaller numbers,
    so there are 2 ^ i sequences in which A[i] is maximum.
    we should do res += A[i] * (2 ^ i)

    There are n - i - 1 bigger numbers,
    so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
    we should do res -= A[i] * 2 ^ (n - i - 1)

    Done.

    Time Complexity:
    O(NlogN)*/

    public int sumSubseqWidths(int[] A) {
        final int MOD = 1000000007;
        Arrays.sort(A);
        long sum = 0, c = 1;
        for (int i = 0; i < A.length; i++, c = (c << 1) % MOD) {
            sum = (sum + A[i] * c - A[A.length - i - 1] * c) % MOD;
        }

        return (int) sum;
    }
}
