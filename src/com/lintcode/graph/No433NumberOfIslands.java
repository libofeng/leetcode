package com.lintcode.graph;

public class No433NumberOfIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    count++;
                    dfsMark(grid, i, j);
                }
            }
        }

        return count;
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfsMark(boolean[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || !grid[x][y]) return;

        grid[x][y] = false;
        for (int[] dir : dirs) dfsMark(grid, x + dir[0], y + dir[1]);
    }
}
