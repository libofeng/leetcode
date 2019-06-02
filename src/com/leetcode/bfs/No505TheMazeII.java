package com.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No505TheMazeII {
    // https://leetcode.com/problems/the-maze-ii/discuss/98392/Similar-to-The-Maze.-Easy-understanding-Java-bfs-solution.
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return bfs(maze, new int[]{start[0], start[1], 0}, destination);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int bfs(int[][] maze, int[] start, int[] dst) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        final Queue<int[]> q = new LinkedList<>();
        final int[][] result = new int[m][n];
        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);

        q.offer(start);

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], steps = p[2];
            maze[x][y] = 2;

            if (steps >= result[x][y]) continue;
            result[x][y] = steps;

            if (x == dst[0] && y == dst[1]) continue;
            for (int[] dir : dirs) q.offer(keepGoing(maze, p, dir));
        }

        return result[dst[0]][dst[1]] == Integer.MAX_VALUE ? -1 : result[dst[0]][dst[1]];
    }

    private int[] keepGoing(int[][] maze, int[] start, int[] dir) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        int x = start[0] + dir[0], y = start[1] + dir[1], steps = start[2] + 1;
        while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
            x += dir[0];
            y += dir[1];
            steps++;
        }

        return new int[]{x - dir[0], y - dir[1], steps - 1};
    }
}
