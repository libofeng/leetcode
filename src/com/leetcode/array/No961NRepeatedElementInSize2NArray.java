package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class No961NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        final Set<Integer> set = new HashSet<>();
        for (int n : A) if (!set.add(n)) return n;
        return 0;
    }

    // https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/208563/JavaC%2B%2BPython-O(1)-Solution

    // Check if A[i] == A[i - 1] or A[i] == A[i - 2]
    // If so, we return A[i]
    // If not, it must be [x, x, y, z] or [x, y, z, x].
    // We return A[0] for the cases that we miss.
    // O(N) time O(1) space

    public int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; i++) if (A[i] == A[i - 1] || A[i] == A[i - 2]) return A[i];
        return A[0];
    }

    public int repeatedNTimes3(int[] A) {
        int i = 0, j = 0, n = A.length;
        while (i == j || A[i] != A[j]) {
            i = (int) (Math.random() * n);
            j = (int) (Math.random() * n);
        }
        return A[i];
    }

}
