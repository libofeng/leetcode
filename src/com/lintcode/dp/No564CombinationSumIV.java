package com.lintcode.dp;

public class No564CombinationSumIV {
    /**
     * @param nums:   an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        if (target == 0 || nums == null || nums.length == 0) return 0;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            count += helper(nums, target - nums[i]);
        }
        return count;
    }

    public int backPackVI2(int[] nums, int target) {
        if (target == 0 || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) for (int n : nums) if (i >= n) dp[i] += dp[i - n];

        return dp[target];
    }
}
