package com.leetcode.interval;

import java.util.List;

public class MaximumWeightNonOverlapIntervals {
    int maxWeight(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        return helper(intervals, intervals.size() - 1);
    }

    private int helper(List<WeightedInterval> intervals, int n) {
        if (n < 0) return 0;
        final WeightedInterval interval = intervals.get(n);

        int i = n - 1;
        while (i >= 0) {
            WeightedInterval prev = intervals.get(i);
            if (prev.end < interval.start) break;

            i--;
        }

        return Math.max(interval.weight + helper(intervals, i), helper(intervals, n - 1));
    }


    int maxWeight2(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        final int n = intervals.size();
        final int[] dp = new int[n];

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            WeightedInterval interval = intervals.get(i);
            dp[i] = interval.weight;

            for (int j = i - 1; j >= 0; j--) {
                WeightedInterval prev = intervals.get(j);
                if (prev.end < interval.start) dp[i] = Math.max(dp[i], dp[j] + interval.weight);
            }

            maxWeight = Math.max(maxWeight, dp[i]);
        }

        return maxWeight;
    }
}
