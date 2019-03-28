package com.leetcode.array;

public class No162FindPeakElement {
    // O(N)
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            long left = i - 1 < 0 ? Long.MIN_VALUE : nums[i - 1];
            long right = i + 1 >= nums.length ? Long.MIN_VALUE : nums[i + 1];

            if (nums[i] > left && nums[i] > right) return i;
        }
        return -1;
    }

    // O(LogN)
    public int findPeakElement2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
