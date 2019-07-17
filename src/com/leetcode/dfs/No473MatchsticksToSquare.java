package com.leetcode.dfs;

import java.util.Arrays;

public class No473MatchsticksToSquare {
    // https://leetcode.com/problems/matchsticks-to-square/discuss/95729/Java-DFS-Solution-with-Explanation
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, new int[4], sum / 4);
    }

    private boolean dfs(int[] nums, int index, int[] sums, int target) {
        if (index < 0) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;

            sums[i] += nums[index];
            if (dfs(nums, index - 1, sums, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }
}
