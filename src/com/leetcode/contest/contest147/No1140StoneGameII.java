package com.leetcode.contest.contest147;

import java.util.HashMap;
import java.util.Map;

public class No1140StoneGameII {
    public int stoneGameII(int[] piles) {
        final int n = piles.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + piles[i - 1];

        return play(sums, 0, 1, new HashMap<>());
    }

    private int play(int[] sums, int start, int m, Map<String, Integer> cache) {
        if (start == sums.length - 1) return 0;
        String key = start + "_" + m;
        if (cache.containsKey(key)) return cache.get(key);

        int otherMin = Integer.MAX_VALUE, total = sums[sums.length - 1] - sums[start];
        for (int i = start; i < start + m * 2 && i < sums.length - 1; i++) {
            int other = play(sums, i + 1, Math.max(m, i - start + 1), cache);
            otherMin = Math.min(otherMin, other);
        }

        int r = total - otherMin;
        cache.put(key, r);
        return r;
    }
}
