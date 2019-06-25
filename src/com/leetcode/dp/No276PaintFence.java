package com.leetcode.dp;

public class No276PaintFence {
    public int numWays(int n, int k) {
        if (n <= 1) return n * k;

        int diff = k * (k - 1), same = k;
        for (int i = 3; i <= n; i++) {
            int prevDiff = diff;
            diff = (same + diff) * (k - 1);
            same = prevDiff;
        }

        return diff + same;
    }
}
