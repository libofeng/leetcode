package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No70ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n <= 3) return n;

        int r = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, r);
        return r;
    }

    public int climbStairs2(int n) {
        int prev = 0, current = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = current;
            current += prev;
            prev = tmp;
        }

        return current;
    }
}
