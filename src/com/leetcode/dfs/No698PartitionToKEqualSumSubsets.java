package com.leetcode.dfs;

import java.util.Arrays;

public class No698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;

        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, k, new int[k], sum / k);
    }

    private boolean dfs(int[] nums, int index, int k, int[] sums, int target) {
        if (index < 0) {
            for (int sum : sums) if (sum != target) return false;
            return true;
        }

        for (int i = 0; i < k; i++) {
            if ((i > 0 && sums[i] == sums[i - 1]) || sums[i] + nums[index] > target) continue;

            sums[i] += nums[index];
            if (dfs(nums, index - 1, k, sums, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }
}
