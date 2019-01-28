package com.leetcode.math;

public class No69SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        long i = x;
        while (i > x / i) i = (i + x / i) / 2;

        return (int) i;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;

        long lo = 1, hi = x;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == x) return (int) mid;

            if (mid * mid > x) hi = mid - 1;
            else lo = mid + 1;
        }

        return (int) (lo * lo > x ? (lo - 1) : lo);
    }


    public int mySqrt3(int x) {
        if (x <= 1) return x;

        for (long i = x / 2; i > 0; i--) if (i * i <= x) return (int) i;
        return 0;
    }
}
