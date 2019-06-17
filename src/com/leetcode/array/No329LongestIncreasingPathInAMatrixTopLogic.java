package com.leetcode.array;

import java.util.*;

public class No329LongestIncreasingPathInAMatrixTopLogic {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length < 1) return 0;

        Map<Point, Set<Point>> graph = new HashMap<>();
        Map<Point, Integer> indegree = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Point p = new Point(i, j);
                if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
                    Point next = new Point(i - 1, j);
                    graph.computeIfAbsent(p, k -> new HashSet<>()).add(next);
                    indegree.put(next, indegree.getOrDefault(next, 0) + 1);
                }
                if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
                    Point next = new Point(i, j - 1);
                    graph.computeIfAbsent(p, k -> new HashSet<>()).add(next);
                    indegree.put(next, indegree.getOrDefault(next, 0) + 1);
                }
                if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
                    Point next = new Point(i + 1, j);
                    graph.computeIfAbsent(p, k -> new HashSet<>()).add(next);
                    indegree.put(next, indegree.getOrDefault(next, 0) + 1);
                }
                if (j < matrix[i].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
                    Point next = new Point(i, j + 1);
                    graph.computeIfAbsent(p, k -> new HashSet<>()).add(next);
                    indegree.put(next, indegree.getOrDefault(next, 0) + 1);
                }
            }
        }
        Queue<Object[]> q = new LinkedList<>();
        int max = 1;
        for (Point p : graph.keySet()) {
            if (indegree.getOrDefault(p, 0) == 0) {
                q.add(new Object[]{p, 0});
            }
        }
        while (!q.isEmpty()) {
            Object[] obj = q.remove();
            Point p = (Point) obj[0];
            int pathLen = (int) obj[1];
            max = Math.max(max, ++pathLen);
            for (Point next : graph.getOrDefault(p, Collections.emptySet())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    q.add(new Object[]{next, pathLen});
                }
            }
        }
        return max;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return p != null && p.x == x && p.y == y;
        }
    }
}
