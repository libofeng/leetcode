package com.leetcode.array;

public class No275HIndexII {

    public int hIndex(int[] citations) {
        int len = citations.length, l = 0, r = len;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] < len - mid) l = mid + 1;
            else r = mid;
        }

        return len - l;
    }
}
