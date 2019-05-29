package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No447NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        final Map<Long, Integer> counter = new HashMap<>();
        final int m = points.length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) continue;

                long d = distance(points[i], points[j]);
                counter.put(d, counter.getOrDefault(d, 0) + 1);
            }
            for (int c : counter.values()) if (c > 1) count += (c - 1) * c;
            counter.clear();
        }

        return count;
    }

    private long distance(int[] p, int[] q) {
        int dx = p[0] - q[0], dy = p[1] - q[1];
        return dx * dx + dy * dy;
    }
}
