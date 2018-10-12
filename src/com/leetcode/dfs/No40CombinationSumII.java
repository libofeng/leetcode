package com.leetcode.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> R = new LinkedList<>();

        dfs(candidates, target, R, new LinkedList<>(), 0);

        return R;
    }

    private void dfs(int[] c, int t, List<List<Integer>> R, LinkedList<Integer> list, int start) {
        if (start >= c.length || t <= 0) {
            if (t == 0) R.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if (i > start && c[i] == c[i - 1]) continue;

            list.add(c[i]);
            dfs(c, t - c[i], R, list, i + 1);
            list.removeLast();
        }
    }
}
