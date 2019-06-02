package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No490TheMaze {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return bfs(maze, new Point(start[0], start[1], 0), destination);
    }

    private boolean bfs(int[][] maze, Point start, int[] dst) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        final Point[][] visited = new Point[m][n];
        final Queue<Point> q = new LinkedList<>();

        q.offer(start);
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (visited[p.x][p.y] != null && p.compareTo(visited[p.x][p.y]) >= 0) continue;
            visited[p.x][p.y] = p;
            if (p.x == dst[0] && p.y == dst[1]) return true;

            for (int[] dir : dirs) q.offer(keepGoing(maze, p, dir, dst));
        }

        return false;
    }

    private Point keepGoing(int[][] maze, Point p, int[] dir, int[] dst) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        int x = p.x + dir[0], y = p.y + dir[1], steps = p.steps + 1;
        while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
            x += dir[0];
            y += dir[1];
            steps++;
        }

        return new Point(x - dir[0], y - dir[1], steps - 1);
    }

    class Point implements Comparable<Point> {
        int x, y, steps;

        Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        public int compareTo(Point that) {
            return this.steps - that.steps;
        }
    }
}
