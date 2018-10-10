package com.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> R = new LinkedList<>();
        dfs(nums, R, new LinkedList<>(), 0);

        return R;
    }

    private void dfs(int[] nums, List<List<Integer>> R, List<Integer> list, int start) {
        R.add(new LinkedList<>(list));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, R, list, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        final List<List<Integer>> R = new LinkedList<>();

        int total = (int) Math.pow(2, nums.length);
        for (int i = 0; i < total; i++) {
            List<Integer> list = new LinkedList<>();
            for (int k = 0; k < nums.length; k++) {
                if (((i >> k) & 1) == 1) list.add(nums[k]);
            }
            R.add(list);
        }

        return R;
    }

}
