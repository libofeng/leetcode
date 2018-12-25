package com.leetcode.dp;

public class No198HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        return dp[dp.length - 1];
    }


    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int left = nums[0], right = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(left + nums[i], right);
            left = right;
            right = max;
        }

        return right;
    }
}
