package com.leetcode.contest.contest124;

public class No995MinimumNumberOfKConsecutiveBitFlips2 {
    public int minKBitFlips(int[] A, int K) {
        int start = 0;
        int l = A.length;
        int count = 0;
        while (start <= l - K) {
            while (start <= l - K && A[start] == 1) start++;
            if (start > l - K) break;
            for (int i = start; i < l && i < start + K; i++) {
                A[i] = A[i] == 1 ? 0 : 1;
            }
            count++;
            start++;
        }
        for (int i = 0; i < l; i++) {
            if (A[i] == 0) return -1;
        }
        return count;
    }
}
