package com.leetcode.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No377CombinationSumIV {
    // Recursive
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;

        int count = 0;
        for (int n : nums) if (n <= target) count += combinationSum4(nums, target - n);
        return count;
    }

    // -----------------------------------------------------

    // Recursive with cache | DP(Top-Bottom)
    public int combinationSum4_2(int[] nums, int target) {
        final Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        return helper(nums, cache, target);
    }

    public int helper(int[] nums, Map<Integer, Integer> cache, int t) {
        if (cache.containsKey(t)) return cache.get(t);

        int count = 0;
        for (int n : nums) if (n <= t) count += helper(nums, cache, t - n);
        cache.put(t, count);

        return count;
    }
    // -----------------------------------------------------


    // dfs + backtracking
    private int count = 0;

    public int combinationSum42(int[] nums, int target) {
        dfs(nums, target);
        return count;
    }

    private void dfs(int[] nums, int t) {
        if (t <= 0) {
            if (t == 0) count++;
            return;
        }

        for (int num : nums) dfs(nums, t - num);
    }

    // -----------------------------------------------------


    // DP(Bottom-Top)
    public int combinationSum4_3(int[] nums, int target) {
        final int[] f = new int[target + 1];
        f[0] = 1;

        for (int i = 1; i <= target; i++) for (int num : nums) if (i >= num) f[i] += f[i - num];
        return f[target];
    }
}
