package com.leetcode.dfs;

public class No494TargetSum {
    int count = 0;

    // DFS
    // Time Complexity: 1 -> 2. O(2^N), Space Complexity: O(N)
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S);
        return count;
    }

    private void dfs(int[] nums, int i, int s) {
        if (i == nums.length) {
            if (s == 0) count++;
            return;
        }

        dfs(nums, i + 1, s + nums[i]);
        dfs(nums, i + 1, s - nums[i]);
    }

    // DP
    // since "The sum of elements in the given array will not exceed 1000."
    // Time Complexity: O(2000* N) = O(N), Space Complexity: O(2000) = O(1)
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (S < -sum || S > sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;

        for (int n : nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 0) continue;
                next[i + n] += dp[i];
                next[i - n] += dp[i];
            }
            dp = next;
        }

        return dp[sum + S];
    }
}
