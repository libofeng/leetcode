package com.leetcode.interval;

import java.util.List;

public class MaximumWeightNonOverlapIntervals {
    // Time: O(2^N), Space: O(2^N)
    int maxWeight(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        return helper(intervals, intervals.size());
    }

    private int helper(List<WeightedInterval> intervals, int i) {
        if (i == 0) return 0;
        final WeightedInterval interval = intervals.get(i - 1);

        int j = i - 1;
        for (; j > 0; j--) if (intervals.get(j - 1).end < interval.start) break;

        return Math.max(interval.weight + helper(intervals, j), helper(intervals, i - 1));
    }

    // DP
    // Time: O(N^2), Space: O(N)
    int maxWeight2(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        final int n = intervals.size();
        final int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            WeightedInterval interval = intervals.get(i - 1);

            int j = i - 1;
            for (; j > 0; j--) if (intervals.get(j - 1).end < interval.start) break;
            dp[i] = Math.max(dp[i - 1], dp[j] + interval.weight);
        }

        return dp[n];
    }
}
