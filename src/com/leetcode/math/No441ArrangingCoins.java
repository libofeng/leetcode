package com.leetcode.math;

public class No441ArrangingCoins {
    public int arrangeCoins(int n) {
        long total = 2L * n;
        long k = (long) Math.sqrt(total);
        while (k * (k + 1) > total) k--;

        return (int) k;
    }

    public int arrangeCoins2(int n) {
        if (n == 0) return 0;

        long n2 = 2L * n, lo = 1, hi = (long) Math.sqrt(n2);
        while (lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2, sum = mid * (mid + 1);
            if (sum == n2) return (int) mid;

            if (sum > n2) hi = mid - 1;
            else lo = mid;
        }

        return (int) (hi * (hi + 1) > n2 ? lo : hi);
    }

    // another Binary Search
    public int arrangeCoins3(int n) {
        long n2 = 2L * n, lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2, sum = mid * (mid + 1);

            if (sum > n2) hi = mid - 1;
            else lo = mid + 1;
        }

        return (int) (lo - 1);
    }
}
