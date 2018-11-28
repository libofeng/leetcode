package com.lintcode.math;

public class No141SqrtX {
    public int sqrt(int x) {
        if (x <= 1) return x;
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (x / mid >= mid) lo = mid + 1;
            else hi = mid;
        }

        return hi - 1;
    }

    // https://www.cnblogs.com/grandyang/p/4346413.html

    public int sqrt2(int x) {
        long r = x;
        while (r * r > x) r = (r + x / r) / 2;
        return (int) r;
    }

    public int sqrt3(int x) {
        if (x <= 1) return x;
        int l = 0, r = x;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x) return (int) mid;

            if (mid * mid < x) l = (int) (mid + 1);
            else r = (int) (mid - 1);
        }
        return r;
    }
}
