package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No505TheMazeII {
    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return bfs(maze, start, destination);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int bfs(int[][] maze, int[] start, int[] dst) {
        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});

        int minSteps = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] src = q.poll();
            int x = src[0], y = src[1], steps = src[2];
            maze[x][y] = 2;
            if (x == dst[0] && y == dst[1]) {
                minSteps = Math.min(minSteps, steps);
                continue;
            }

            for (int[] dir : dirs) {
                int[] next = keepGoing(maze, src, dir);
                if (next[2] == steps) continue;
                if (maze[next[0]][next[1]] == 2) continue;

                q.offer(next);
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    private int[] keepGoing(int[][] maze, int[] start, int[] dir) {
        final int m = maze.length, n = maze[0].length;
        final int x = start[0] + dir[0], y = start[1] + dir[1], steps = start[2] + 1;

        if (x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == 1) return start;
        return keepGoing(maze, new int[]{x, y, steps}, dir);
    }
}
