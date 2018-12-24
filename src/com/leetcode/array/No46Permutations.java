package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class No46Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, permutations, used, new ArrayList<>());
        return permutations;
    }

    private void dfs(int[] nums, List<List<Integer>> p, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            p.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.add(nums[i]);
            dfs(nums, p, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
