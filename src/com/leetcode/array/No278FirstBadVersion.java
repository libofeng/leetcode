package com.leetcode.array;

public class No278FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean isBadVersion(int v) {
        return true;
    }
}
