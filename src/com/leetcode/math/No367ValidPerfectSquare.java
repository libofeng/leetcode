package com.leetcode.math;

public class No367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        long n = num;
        while (n * n > num) n = (n + num / n) / 2;

        return n * n == num;
    }

    public boolean isPerfectSquare2(int num) {
        if (num <= 1) return true;

        int lo = 1, hi = num;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (num / mid >= mid) lo = mid + 1;
            else hi = mid;
        }

        return (hi - 1) * (hi - 1) == num;
    }
}
