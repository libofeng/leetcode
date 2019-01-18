package com.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class No695MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return 0;

        grid[x][y] = 0;
        int area = 1;
        for (int[] dir : dirs) area += dfs(grid, x + dir[0], y + dir[1]);

        return area;
    }

    private int bfs(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        final Queue<int[]> q = new LinkedList<>();

        grid[x][y] = 0;
        q.offer(new int[]{x, y});
        int area = 1;

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] dir : dirs) {
                int i = cell[0] + dir[0], j = cell[1] + dir[1];
                if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1) {
                    area++;
                    grid[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        return area;
    }
}
