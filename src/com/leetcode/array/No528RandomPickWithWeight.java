package com.leetcode.array;

import java.util.Random;

public class No528RandomPickWithWeight {
    private int[] sum;
    private Random rnd = new Random();

    public No528RandomPickWithWeight(int[] w) {
        sum = new int[w.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + w[i - 1];
    }

    public int pickIndex() {
        int w = rnd.nextInt(sum[sum.length - 1]);

        int lo = 0, hi = sum.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (w >= sum[mid]) lo = mid;
            else hi = mid - 1;
        }

        return w >= sum[hi] ? hi : (hi - 1);
    }
}
