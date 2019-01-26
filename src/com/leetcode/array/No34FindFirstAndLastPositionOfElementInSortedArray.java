package com.leetcode.array;

public class No34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        final int[] NOT_FOUND = new int[]{-1, -1};
        if (nums.length == 0) return NOT_FOUND;

        int lo = findLowBound(nums, target);
        if (lo == -1) return NOT_FOUND;

        int hi = findHiBound(nums, lo, target);
        return new int[]{lo, hi};
    }

    private int findLowBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) lo = mid + 1;
            else hi = mid;
        }

        return nums[lo] == target ? lo : -1;
    }

    private int findHiBound(int[] nums, int lo, int target) {
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) hi = mid - 1;
            else lo = mid;
        }

        return nums[hi] == target ? hi : lo;
    }
}
