package com.leetcode.geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No587ErectTheFence {
    // https://www.youtube.com/watch?v=Vu84lmMzP2o&feature=youtu.be
    public int[][] outerTrees(int[][] points) {
        final int n = points.length;
        final Set<Integer> list = new HashSet<>();

        int start = 0;
        for (int i = 1; i < n; i++) if (points[i][0] < points[start][0]) start = i;
        list.add(start);

        int current = start;
        while (true) {
            int next = 0;
            List<Integer> collinearPoints = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (i == current) continue;

                int crossProduct = crossProduct(points[current], points[next], points[i]);
                if (crossProduct > 0) {
                    next = i;
                    collinearPoints = new ArrayList<>();
                } else if (crossProduct == 0) {
                    if (distance(points[current], points[next], points[i]) < 0) {
                        collinearPoints.add(next);
                        next = i;
                    } else collinearPoints.add(i);
                }
            }

            list.addAll(collinearPoints);
            if (next == start) break;

            list.add(next);
            current = next;
        }

        final int[][] result = new int[list.size()][2];
        int index = 0;
        for (int i : list) result[index++] = points[i];
        return result;
    }

    private int distance(int[] a, int[] b, int[] c) {
        int x1 = a[0] - b[0], x2 = a[0] - c[0];
        int y1 = a[1] - b[1], y2 = a[1] - c[1];

        return Integer.compare(x1 * x1 + y1 * y1, x2 * x2 + y2 * y2);
    }

    private int crossProduct(int[] a, int[] b, int[] c) {
        int x1 = a[0] - b[0], x2 = a[0] - c[0];
        int y1 = a[1] - b[1], y2 = a[1] - c[1];

        return x1 * y2 - x2 * y1;
    }
}
