package com.leetcode.array;

import java.util.*;

public class No939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        final Map<Integer, List<int[]>> xmap = new HashMap<>();
        for (int[] point : points) {
            xmap.putIfAbsent(point[0], new ArrayList<>());
            xmap.get(point[0]).add(point);
        }

        int area = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] != points[j][1]) continue;

                List<int[]> points1 = xmap.get(points[i][0]), points2 = xmap.get(points[j][0]);

                for (int[] p1 : points1) {
                    for (int[] p2 : points2) {
                        if (p1[1] != p2[1] || points[i][1] == p1[1] || points[j][1] == p2[1]) continue;

                        int a = Math.abs((points[i][1] - p1[1]) * (points[i][0] - points[j][0]));
                        area = Math.min(area, a);
                    }
                }
            }
        }

        return area == Integer.MAX_VALUE ? 0 : area;
    }


    public int minAreaRect2(int[][] points) {
        final Map<Integer, Set<Integer>> xmap = new HashMap<>();
        for (int[] point : points) {
            xmap.putIfAbsent(point[0], new HashSet<>());
            xmap.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                int[] p1 = new int[]{points[i][0], points[j][1]};
                int[] p2 = new int[]{points[j][0], points[i][1]};

                if (xmap.get(p1[0]).contains(p1[1]) && xmap.get(p2[0]).contains(p2[1])) {
                    int area = Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1]));
                    minArea = Math.min(minArea, area);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        No939MinimumAreaRectangle solution = new No939MinimumAreaRectangle();
        int[][] points = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int minArea = solution.minAreaRect2(points);
        System.out.println("minArea = " + minArea);

        points = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        minArea = solution.minAreaRect2(points);
        System.out.println("minArea = " + minArea);
    }
}
