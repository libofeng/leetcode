package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> R = new LinkedList<>();
        dfs(candidates, target, R, 0, new LinkedList<>());

        return R;
    }

    private void dfs(int[] c, int t, List<List<Integer>> R, int start, LinkedList<Integer> list) {
        if (t <= 0) {
            if (t == 0) R.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < c.length; i++) {
            list.add(c[i]);
            dfs(c, t - c[i], R, i, list);
            list.removeLast();
        }
    }
}
