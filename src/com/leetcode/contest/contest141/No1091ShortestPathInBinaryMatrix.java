package com.leetcode.contest.contest141;

import java.util.LinkedList;
import java.util.Queue;

public class No1091ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        final Queue<int[]> q = new LinkedList<>();
        final int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        if (grid[0][0] == 0) {
            q.offer(new int[]{0, 0});
            grid[0][0] = 2;
        }

        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] state = q.poll();
                if (state[0] == m - 1 && state[1] == n - 1) return steps;

                for (int[] dir : dirs) {
                    int x = state[0] + dir[0], y = state[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) continue;

                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }

            steps++;
        }

        return -1;
    }
}
