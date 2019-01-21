package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No403FrogJump {
    final Map<String, Boolean> cache = new HashMap<>();
    final Map<Integer, Integer> map = new HashMap<>();

    public boolean canCross(int[] stones) {
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        return dfs(stones, 0, 1);
    }

    private boolean dfs(int[] stones, int index, int steps) {
        String key = index + "-" + steps;
        if (cache.containsKey(key)) return cache.get(key);
        if (steps < 1 || !map.containsKey(stones[index] + steps)) return false;

        int next = map.get(stones[index] + steps);
        if (next == stones.length - 1) return true;

        boolean can = dfs(stones, next, steps) || dfs(stones, next, steps - 1) || dfs(stones, next, steps + 1);
        cache.put(key, can);
        return can;
    }

    @SuppressWarnings("unchecked")
    // use a collection (set) to store all the possible steps for every stones.
    public boolean canCross2(int[] stones) {
        final Set[] dp = new Set[stones.length];
        for (int i = 0; i < dp.length; i++) dp[i] = new HashSet();
        dp[0].add(1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int step = stones[i] - stones[j];
                if (dp[j].contains(step)) {
                    dp[i].add(step - 1);
                    dp[i].add(step);
                    dp[i].add(step + 1);
                }
            }
        }

        return dp[dp.length - 1].size() > 0;
    }

    public boolean canCross3(int[] stones) {
        final int N = stones.length;
        final boolean[][] dp = new boolean[N][N + 1];
        dp[0][1] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int step = stones[i] - stones[j];
                if (step < 0 || step > N) continue;

                if (dp[j][step]) {
                    if (i == N - 1) return true;

                    if (step - 1 > 0 && step - 1 <= N) dp[i][step - 1] = true;
                    dp[i][step] = true;
                    if (step + 1 > 0 && step + 1 <= N) dp[i][step + 1] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        No403FrogJump solution = new No403FrogJump();
        boolean can = solution.canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12});
        System.out.println("can = " + can);

        can = solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        System.out.println("can = " + can);
    }
}
