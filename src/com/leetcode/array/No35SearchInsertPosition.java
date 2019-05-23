package com.leetcode.array;

public class No35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) return mid;

            if (target > nums[mid]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
