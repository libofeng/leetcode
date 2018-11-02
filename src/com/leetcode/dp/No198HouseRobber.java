package com.leetcode.dp;

public class No198HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        return dp[dp.length - 1];
    }

}
