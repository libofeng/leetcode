package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        if (list.size() > 1) result.add(new ArrayList<>(list));

        final Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            int n = nums[i];
            // if(i>start && n == nums[i-1]) continue;  // WRONG
            if (!set.add(n)) continue;
            if (!list.isEmpty() && n < list.get(list.size() - 1)) continue;

            list.add(n);
            dfs(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
