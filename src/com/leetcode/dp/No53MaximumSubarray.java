package com.leetcode.dp;

public class No53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            maxSum = Math.max(sum, maxSum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public int maxSubArray3(int[] nums) {
        int sum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // simplify from maxSubArray3
    public int maxSubArray4(int[] nums) {
        int max = nums[0];
        for (int i = 1, sum = nums[0]; i < nums.length; i++) max = Math.max(max, sum = (Math.max(nums[i], sum + nums[i])));

        return max;
    }
}
