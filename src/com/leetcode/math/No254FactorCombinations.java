package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No254FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> result = new ArrayList<>();

        dfs(n, 2, result, new ArrayList<>());
        return result;
    }

    private void dfs(int n, int start, List<List<Integer>> result, List<Integer> list) {
        if (n == 1) {
            if (list.size() > 1) result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i > 0) continue;

            list.add(i);
            dfs(n / i, i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
