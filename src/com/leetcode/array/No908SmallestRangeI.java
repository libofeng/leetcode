package com.leetcode.array;

public class No908SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : A) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return Math.max((max - K) - (min + K), 0);
    }
}
