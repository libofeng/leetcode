package com.leetcode.contest.contest153;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class No5184MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        final TreeSet<Integer> s = new TreeSet<>();
        for (int i : arr2) s.add(i);

        TreeMap<Integer, Integer> current = new TreeMap<>();
        current.put(Integer.MIN_VALUE, 0);

        for (int n : arr1) {
            TreeMap<Integer, Integer> next = new TreeMap<>();

            for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
                Integer nextNumber = s.ceiling(entry.getKey() + 1);
                if (nextNumber != null) next.put(nextNumber, entry.getValue() + 1);
            }

            Map.Entry<Integer, Integer> floor = current.floorEntry(n - 1);
            if (floor != null) {
                Map.Entry<Integer, Integer> ceiling;
                while ((ceiling = next.ceilingEntry(n)) != null && ceiling.getValue() >= floor.getValue()) {
                    next.remove(ceiling.getKey());
                }

                if (!next.containsKey(n)) next.put(n, floor.getValue());
            }

            current = next;
        }

        if (current.isEmpty()) return -1;

        int min = Integer.MAX_VALUE;
        for (int i : current.values()) min = Math.min(min, i);
        return min;
    }

    // https://leetcode.com/problems/make-array-strictly-increasing/discuss/377680/Simple-Java-DP-Solution-%2B-TreeSet-with-Explanation-beats-100
    public int makeArrayIncreasing2(int[] arr1, int[] arr2) {
        final int m = arr1.length;
        if (m == 0) return -1;
        if (m == 1) return 0;

        final TreeSet<Integer> tm = new TreeSet<>();
        for (int n : arr2) tm.add(n);

        final int[][] dp = new int[m + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = Integer.MIN_VALUE;

        // under the same operation times, keep the minimum number in dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr1[i - 1] > dp[i - 1][j]) dp[i][j] = arr1[i - 1];

                Integer higher = j > 0 && dp[i - 1][j - 1] < Integer.MAX_VALUE ? tm.higher(dp[i - 1][j - 1]) : null;
                if (higher != null) dp[i][j] = Math.min(dp[i][j], higher);

                // return the result when first time we find a valid increasing sequence.
                if (i == m && dp[i][j] < Integer.MAX_VALUE) return j;
            }
        }

        return -1;
    }
}
