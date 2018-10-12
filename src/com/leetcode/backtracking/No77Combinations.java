package com.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class No77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> R = new LinkedList<>();

        dfs(n, k, R, new LinkedList<>(), 1);

        return R;
    }

    private void dfs(int n, int k, List<List<Integer>> R, LinkedList<Integer> list, int start) {
        if (list.size() == k) {
            R.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, R, list, i + 1);
            list.removeLast();
        }
    }
}
