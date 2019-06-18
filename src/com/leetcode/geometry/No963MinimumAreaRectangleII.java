package com.leetcode.geometry;

import java.awt.*;
import java.util.*;
import java.util.List;

public class No963MinimumAreaRectangleII {
    public double minAreaFreeRect(int[][] points) {
        final int n = points.length;
        if (n < 4) return 0D;

        final Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final int[] a = points[i], b = points[j];
                long distance = distanceSqure(a, b);
                double midX = ((double) a[0] + b[0]) / 2;
                double midY = ((double) a[1] + b[1]) / 2;

                String key = distance + "_" + midX + "_" + midY;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        double minArea = Double.MAX_VALUE;
        for (List<int[]> list : map.values()) {
            if (list.size() < 2) continue;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] a = points[list.get(i)[0]];
                    int[] b = points[list.get(j)[0]], c = points[list.get(j)[1]];

                    double d1 = Math.sqrt(distanceSqure(a, b)), d2 = Math.sqrt(distanceSqure(a, c));
                    minArea = Math.min(minArea, d1 * d2);
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0D : minArea;
    }

    private long distanceSqure(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return x * x + y * y;
    }

    public double minAreaFreeRect2(int[][] points) {
        int N = points.length;

        Point[] arr = new Point[N];
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < points.length; ++i) {
            Point p = new Point(points[i][0], points[i][1]);
            set.add(p);
            arr[i] = p;
        }
        int len = points.length;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            Point p1 = arr[i];
            for (int j = i + 1; j < len; ++j) {
                Point p2 = arr[j];
                for (int k = j + 1; k < len; ++k) {
                    Point p3 = arr[k];
                    int cross = (p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y);
                    if (cross != 0) continue;
                    Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                    if (set.contains(p4)) {
                        res = Math.min(res, p1.distance(p2) * p1.distance(p3));
                    }
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }

    // https://leetcode.com/problems/minimum-area-rectangle-ii/discuss/208470/Java-O(N3)-bruteforce
    public double minAreaFreeRect3(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + " " + p[1]);
        }
        double result = Double.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    continue;
                }
                for (int[] p3 : points) {
                    if (dist(p1, p3) + dist(p2, p3) != dist(p1, p2)) {
                        continue;
                    }
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!set.contains(x + " " + y)) {
                        continue;
                    }
                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    if (Double.compare(area, 0) == 0) {
                        continue;
                    }
                    result = Math.min(result, area);
                }
            }
        }
        return Double.compare(Double.MAX_VALUE, result) == 0 ? 0 : result;
    }
    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
