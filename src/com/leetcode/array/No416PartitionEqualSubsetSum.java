package com.leetcode.array;

public class No416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;

        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++)
                if (j >= nums[i - 1]) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }

        return dp[nums.length][sum];
    }

    // https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (nums.length == 1 || sum % 2 == 1) return false;

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        // pay attention to the order
        for (int n : nums) for (int j = sum; j > 0; j--) if (j >= n) dp[j] = dp[j] || dp[j - n];

        return dp[sum];
    }
}
