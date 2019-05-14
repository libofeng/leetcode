package com.leetcode.dfs;

public class No548SplitArrayWithEqualSum {
    public boolean splitArray(int[] nums) {
        int sum = 0, target = 0;
        for (int n : nums) sum += n;
        for (int i = 1; i < nums.length; i++) {
            if (i > 1 && nums[i] == 0 && nums[i - 1] == 0) continue;
            target += nums[i - 1];
            if (dfs(nums, target, i + 1, sum - target - nums[i], 1)) return true;
        }

        return false;
    }

    private boolean dfs(int[] nums, int target, int start, int left, int level) {
        if (level == 3) {
            return target == left;
        }

        int sum = 0;
        for (int j = start + 1; j < nums.length - 5 + 2 * level; j++) {
            sum += nums[j - 1];
            if (sum == target && dfs(nums, target, j + 1, left - sum - nums[j], level + 1)) return true;
        }

        return false;
    }
}
