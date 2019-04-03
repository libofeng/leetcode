package com.leetcode.array;

public class No81SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;

            if (nums[lo] < nums[hi]) {
                if (target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[lo] > nums[hi]) {
                if (nums[mid] >= nums[lo]) {
                    if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                    else lo = mid + 1;
                } else {
                    if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
                    else hi = mid - 1;
                }
            } else lo++;
        }

        return false;
    }
}
