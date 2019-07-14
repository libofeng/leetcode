package com.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class No514FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, new HashMap<>());
    }

    private int dfs(String ring, String key, int index, Map<String, Integer> cache) {
        if (index == key.length()) return 0;

        String cacheKey = ring + index;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        char c = key.charAt(index);
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (c == ring.charAt(i)) {
                String next = ring.substring(i) + ring.substring(0, i);
                int steps = 1 + Math.min(i, ring.length() - i);
                steps += dfs(next, key, index + 1, cache);
                minSteps = Math.min(minSteps, steps);
            }
        }

        cache.put(cacheKey, minSteps);
        return minSteps;
    }

    // DP
    public int findRotateSteps2(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        // Add m at last, because spelling of each char takes 1 step.
        return dp[0][0] + m;
    }

    public int findRotateSteps3(String ring, String key) {
        final int m = key.length(), n = ring.length();
        final int[][] dp = new int[m + 1][n];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (key.charAt(m - i) != ring.charAt(k)) continue;
                    int distance = Math.abs(j - k), steps = Math.min(distance, n - distance);
                    dp[i][j] = Math.min(dp[i][j], steps + dp[i - 1][k]);
                }
            }
        }

        return dp[m][0] + m;
    }
}
