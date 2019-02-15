package com.leetcode.array;

public class No852PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) if (A[i] > A[i + 1]) return i;
        return 0;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;

            if (A[mid] > A[mid - 1]) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }
}
