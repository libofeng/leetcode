package com.leetcode.array;

import java.util.Random;

public class No528RandomPickWithWeight {
    private final int[] sums;
    private final Random rnd = new Random();

    public No528RandomPickWithWeight(int[] w) {
        sums = new int[w.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + w[i - 1];
    }

    public int pickIndex() {
        final int w = rnd.nextInt(sums[sums.length - 1]);

        int lo = 1, hi = sums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (w < sums[mid] && w >= sums[mid - 1]) return mid - 1;

            if (w >= sums[mid]) lo = mid + 1;
            else hi = mid - 1;
        }

        return 0;
    }
}
