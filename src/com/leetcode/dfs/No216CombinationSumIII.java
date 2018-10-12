package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> R = new LinkedList<>();

        dfs(k, n, R, new LinkedList<>(), 1);

        return R;
    }

    private void dfs(int k, int n, List<List<Integer>> R, LinkedList<Integer> list, int start) {
        if (n <= 0 || list.size() >= k) {
            if (list.size() == k && n == 0) R.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(k, n - i, R, list, i + 1);
            list.removeLast();
        }
    }
}
