package com.leetcode.dp;

public class No213HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int sum1 = 0, sum2 = 0;
        for (int i = start; i < end; i++) sum2 = Math.max(sum1 + nums[i], (sum1 = sum2));
        return sum2;
    }
}
