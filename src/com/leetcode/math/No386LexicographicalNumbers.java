package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No386LexicographicalNumbers {

    // Time: O(N), Space: O(LgN) LgN is based 10.
    public List<Integer> lexicalOrder(int n) {
        final List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dfs(n, result, i);
        }
        return result;
    }

    private void dfs(int n, List<Integer> result, int current) {
        if (current > n) return;

        result.add(current);
        for (int i = 0; i < 10; i++) dfs(n, result, current * 10 + i);
    }
}
