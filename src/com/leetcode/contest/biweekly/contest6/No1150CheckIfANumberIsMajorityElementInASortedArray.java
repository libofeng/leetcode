package com.leetcode.contest.biweekly.contest6;

public class No1150CheckIfANumberIsMajorityElementInASortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) if (num == target) count++;

        return count > nums.length / 2;
    }

    public boolean isMajorityElement2(int[] nums, int target) {
        int lo = findLow(nums, target);
        if (lo == -1) return false;

        int hi = findHigh(nums, target);

        return hi - lo + 1 > nums.length / 2;
    }

    private int findLow(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }

        return nums[lo] == target ? lo : -1;
    }

    private int findHigh(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }

        return nums[hi] == target ? hi : lo;
    }
}
