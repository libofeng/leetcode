package com.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class No200NumberOfIslands {
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    dfs(grid, i, j);
                }
            }
        }

        return total;
    }

    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] grid, int i, int j) {
        final int m = grid.length, n = grid[0].length;

        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
            dfs(grid, x, y);
        }
    }


    private void bfsMark(char[][] grid, int i, int j) {
        final int m = grid.length, n = grid[0].length;

        final Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '2';
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0], y = cell[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != '1') continue;

                grid[x][y] = '2';
                q.offer(new int[]{x, y});
            }

        }
    }
}
