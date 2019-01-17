package com.leetcode.array;

public class No33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] < nums[hi]) {
                if (target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (nums[mid] >= nums[lo]) {
                    if (target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                    else lo = mid + 1;
                } else {
                    if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
