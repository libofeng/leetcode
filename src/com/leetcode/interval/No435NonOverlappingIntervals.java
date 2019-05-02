package com.leetcode.interval;

import java.util.Arrays;

public class No435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        int count = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (end > interval[0]) {
                end = Math.min(end, interval[1]);
                count++;
            } else end = interval[1];
        }

        return count;
    }
}
