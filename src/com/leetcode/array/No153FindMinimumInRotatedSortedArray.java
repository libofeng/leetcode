package com.leetcode.array;

public class No153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[lo]) hi = mid;
            else lo = mid + 1;
        }

        return nums[lo];
    }
}
