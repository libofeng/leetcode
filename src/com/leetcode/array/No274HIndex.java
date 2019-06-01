package com.leetcode.array;

import java.util.Arrays;

public class No274HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1, h = 0; i >= 0; i--) if (citations[i] < ++h) return h - 1;
        return citations.length;
    }

    public int hIndex2(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);

        final int n = citations.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((n - mid) > citations[mid]) lo = mid + 1;
            else hi = mid;
        }

        int hIndex = n - lo;
        return citations[lo] >= hIndex ? hIndex : (hIndex - 1);
    }
}
