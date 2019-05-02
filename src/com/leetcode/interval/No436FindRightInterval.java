package com.leetcode.interval;

import java.util.Map;
import java.util.TreeMap;

public class No436FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        final int n = intervals.length;
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) tm.putIfAbsent(intervals[i][0], i);

        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> ceiling = tm.ceilingEntry(intervals[i][1]);
            result[i] = ceiling == null ? -1 : ceiling.getValue();
        }

        return result;
    }
}
