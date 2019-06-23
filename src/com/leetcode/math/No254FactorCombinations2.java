package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No254FactorCombinations2 {
    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> result = new ArrayList<>();

        dfs(n, 2, result, new ArrayList<>());
        return result;
    }

    private void dfs(int n, int start, List<List<Integer>> result, List<Integer> list) {
        for (int i = start; i * i <= n; i++) {
            if (n % i > 0) continue;

            list.add(i);

            list.add(n / i);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);

            dfs(n / i, i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
