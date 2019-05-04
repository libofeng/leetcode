package com.leetcode.interval;

import java.util.Arrays;

public class No452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        if (points.length <= 1) return points.length;

        int[] intersection = points[0];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] next = points[i];

            intersection = intersection(intersection, next);
            if (intersection == null) {
                count++;
                intersection = next;
            }
        }

        return count;
    }

    private int[] intersection(int[] a, int[] b) {
        if (a[1] < b[0] || a[0] > b[1]) return null;

        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}
