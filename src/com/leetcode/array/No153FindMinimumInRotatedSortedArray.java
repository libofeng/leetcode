package com.leetcode.array;

public class No153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l < r - 1) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[l]) l = mid;
            else r = mid;
        }

        return Math.min(nums[l], nums[r]);
    }
}
