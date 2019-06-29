package com.leetcode.contest.biweekly.contest3;

import java.util.TreeSet;

public class No1099TwoSumLessThanKUser {
    public int twoSumLessThanK(int[] A, int K) {
        final TreeSet<Integer> ts = new TreeSet<>();

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int n = A[i], target = K - n;
            Integer lowerKey = ts.lower(target);
            if (lowerKey != null) maxSum = Math.max(maxSum, lowerKey + n);
            ts.add(n);
        }

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}
