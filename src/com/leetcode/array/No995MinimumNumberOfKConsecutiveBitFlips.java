package com.leetcode.array;

public class No995MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        final int n = A.length;
        int count = 0, start = 0;
        while (start <= n - K) {
            while (start <= n - K && A[start] == 1) start++;
            if (start > n - K) break;
            for (int i = start; i < start + K; i++) A[i] = A[i] == 0 ? 1 : 0;

            count++;
            start++;
        }

        for (int a : A) if (a == 0) return -1;
        return count;
    }

    // https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
    public int minKBitFlips2(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
