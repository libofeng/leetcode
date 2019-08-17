package com.leetcode.array;

import java.util.*;

public class No329LongestIncreasingPathInAMatrixTopLogic {
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        final int m = matrix.length, n = matrix[0].length;
        final Map<Point, List<Point>> graph = new HashMap<>();
        final Map<Point, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Point p = new Point(i, j);
                graph.putIfAbsent(p, new ArrayList<>());
                inDegree.putIfAbsent(p, 0);

                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;

                    Point c = new Point(x, y);
                    graph.get(p).add(c);
                    inDegree.put(c, inDegree.getOrDefault(c, 0) + 1);
                }
            }
        }

        final Queue<Object[]> q = new LinkedList<>();
        for (Map.Entry<Point, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) q.offer(new Object[]{e.getKey(), 0});
        }

        int maxLen = 0;
        while (!q.isEmpty()) {
            Point p = (Point) q.peek()[0];
            int len = (Integer) q.poll()[1];
            maxLen = Math.max(maxLen, ++len);

            for (Point next : graph.get(p)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) q.offer(new Object[]{next, len});
            }
        }

        return maxLen;
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            Point that = (Point) o;
            return that != null && this.x == that.x && this.y == that.y;
        }
    }
}
