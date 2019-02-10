package com.leetcode.contest.contest123;

public class No992SubarraysWithKDifferentIntegers {
    // https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/234482/JavaC%2B%2BPython-Sliding-Window

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        int[] count = new int[A.length + 1];
        for (int j = 0; j < A.length; ++j) {
            if (count[A[j]]++ == 0) K--;
            while (K < 0) if (--count[A[i++]] == 0) K++;
            res += j - i + 1;
        }
        return res;
    }

}
