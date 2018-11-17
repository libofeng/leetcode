package com.lintcode.array;

public class No1208TargetSum {
    /**
     * @param nums: the given array
     * @param s:    the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    // DFS
    public int findTargetSumWays(int[] nums, int s) {
        return find(nums, s, 0, 0);
    }

    private int find(int[] A, int s, int i, int sum) {
        if (i == A.length) return s == sum ? 1 : 0;
        else return find(A, s, i + 1, sum + A[i]) + find(A, s, i + 1, sum - A[i]);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) for (int i = s; i >= n; i--) dp[i] += dp[i - n];
        return dp[s];
    }

    // sums = nums[0] + nums[1] + nums[2] + ... + nums[n-2] + nums[n-1]
    // s    = nums[0] + nums[1] - nums[2] + ... + nums[n-2] + nums[n-1]
    // sums + s = 2 * ( nums[0] + nums[1] + ... + nums[n-2] + nums[n-1])
    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }
}
