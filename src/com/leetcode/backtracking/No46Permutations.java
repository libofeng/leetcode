package com.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class No46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> R = new LinkedList<>();
        final boolean[] used = new boolean[nums.length];

        dfs(nums, R, used, new LinkedList<>());

        return R;
    }

    private void dfs(int[] nums, List<List<Integer>> R, boolean[] used, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            R.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.add(nums[i]);
            dfs(nums, R, used, list);
            list.removeLast();
            used[i] = false;
        }
    }
}
