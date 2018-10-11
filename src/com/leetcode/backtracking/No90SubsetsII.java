package com.leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> R = new LinkedList<>();
        dfs(nums, R, 0, new LinkedList<>());
        return R;
    }

    private void dfs(int[] nums, List<List<Integer>> R, int start, List<Integer> list) {
        R.add(new LinkedList<>(list));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, R, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
