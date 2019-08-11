package com.leetcode.contest.contest149;

import java.util.HashMap;
import java.util.Map;

public class No1155NumberOfDiceRollsWithTargetSum {
    private final int MOD = 1000000007;
    // ----------------------------
    private Map<String, Long> cache = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int i = 0; i < d; i++) {
            long[] next = new long[target + 1];
            for (int j = 0; j < target; j++) {
                for (int k = 1; k <= f && j + k <= target; k++) {
                    next[j + k] = (next[j + k] + dp[j]) % MOD;
                }
            }
            dp = next;
        }

        return (int) dp[target];
    }

    public int numRollsToTarget2(int d, int f, int target) {
        return (int) dfs(d, f, target);
    }

    private long dfs(int d, int f, int target) {
        String key = d + "-" + target;
        if (cache.containsKey(key)) return cache.get(key);
        if (target <= 0 || d == 0) return target == 0 && d == 0 ? 1 : 0;

        long total = 0;
        for (int i = 1; i <= f; i++) total = (total + dfs(d - 1, f, target - i)) % MOD;
        cache.put(key, total);

        return total;
    }
}
