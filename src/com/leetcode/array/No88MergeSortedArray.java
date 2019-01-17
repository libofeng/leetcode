package com.leetcode.array;

public class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int idx = m + n - 1, i = m - 1, j = n - 1; j >= 0; ) nums1[idx--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
}
