package com.leetcode.dfs;

public class No361BombEnemy {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Time: O(MN(M+N), Space: O(M+N)
    public int maxKilledEnemies(char[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int maxCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') continue;

                int count = 0;
                for (int[] dir : dirs) count += dfs(grid, i, j, dir, 0);
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    private int dfs(char[][] grid, int i, int j, int[] dir, int c) {
        final int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 'W') return c;

        if (grid[i][j] == 'E') c++;
        return dfs(grid, i + dir[0], j + dir[1], dir, c);
    }
}
