package com.leetcode.search;

public class No374GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int r = guess(mid);
            if (r == 0) return mid;

            if (r > 0) lo = mid + 1;
            else hi = mid - 1;
        }

        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
