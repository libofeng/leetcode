package com.leetcode.array;

import java.util.Arrays;

public class No274HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1, h = 0; i >= 0; i--) if (citations[i] < ++h) return h - 1;
        return citations.length;
    }
}
