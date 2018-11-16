package com.lintcode.array;

import java.util.Arrays;

public class No1304HIndex {
    /**
     * @param citations: a list of integers
     * @return: return a integer
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1, h = 0; i >= 0; i--) if (citations[i] < ++h) return h - 1;
        return citations.length;
    }


    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int l = 0, r = citations.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= citations.length - mid) r = mid;
            else l = mid + 1;
        }

        int h = citations.length - l;
        return citations[l] < h ? h - 1 : h;
    }


    public int hIndex3(int[] citations) {
        final int n = citations.length;
        final int[] bucket = new int[n + 1];
        for (int c : citations) bucket[Math.min(n, c)]++;

        for (int i = n, h = 0; i >= 0; i--) if ((h += bucket[i]) >= i) return i;
        return 0;
    }
}
