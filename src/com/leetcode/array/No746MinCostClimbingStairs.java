package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No746MinCostClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return helper(cost, cost.length);
    }

    private int helper(int[] cost, int n) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n <= 1) return 0;

        int r = Math.min(helper(cost, n - 1) + cost[n - 1], helper(cost, n - 2) + cost[n - 2]);
        cache.put(n, r);

        return r;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int[] R = new int[cost.length + 1];
        for (int i = 2; i < R.length; i++) {
            R[i] = Math.min(cost[i - 1] + R[i - 1], cost[i - 2] + R[i - 2]);
        }

        return R[R.length - 1];
    }

    public int minCostClimbingStairs3(int[] cost) {
        int prev = 0, current = 0;
        for (int i = 2; i <= cost.length; i++) {
            int tmp = current;
            current = Math.min(cost[i - 1] + current, cost[i - 2] + prev);
            prev = tmp;
        }

        return current;
    }
}
