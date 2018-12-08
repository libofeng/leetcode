package com.leetcode.array;

public class No486PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int s, int e) {
        return s == e ? nums[s] : Math.max(nums[s] - helper(nums, s + 1, e), nums[e] - helper(nums, s, e - 1));
    }
}
