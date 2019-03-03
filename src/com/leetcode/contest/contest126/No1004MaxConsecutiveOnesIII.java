package com.leetcode.contest.contest126;

public class No1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int res = 0, zero = 0, left = 0, k = K;
        for (int right = 0; right < A.length; ++right) {
            if (A[right] == 0) ++zero;
            while (zero > k) {
                if (A[left++] == 0) --zero;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
