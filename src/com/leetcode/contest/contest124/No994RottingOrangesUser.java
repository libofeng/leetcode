package com.leetcode.contest.contest124;

import java.util.LinkedList;
import java.util.Queue;

public class No994RottingOrangesUser {
    public int orangesRotting(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length, total = m * n;

        final Queue<int[]> q = new LinkedList<>();
        int totalEmpty = 0, totalFresh = 0, totalRotten = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) totalEmpty++;
                else if (grid[i][j] == 1) totalFresh++;
                else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    totalRotten++;
                }
            }
        }
        if (total - totalEmpty == totalRotten) return 0;
        if (total - totalEmpty == totalFresh) return -1;

        int minutes = -1;
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            while (size-- > 0) {
                int[] p = q.poll();

                for (int[] dir : dirs) {
                    int x = p[0] + dir[0], y = p[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        totalRotten++;
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }

        return (total - totalEmpty != totalRotten) ? -1 : minutes;
    }
}
