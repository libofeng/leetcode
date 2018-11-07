package com.lintcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class No897IslandCity {
    /**
     * @param grid: an integer matrix
     * @return: an integer
     */
    public int numIslandCities(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] g, int row, int col) {
        final int m = g.length, n = g[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || g[row][col] == 0) return;

        g[row][col] = 0;
        for (int[] dir : dirs) dfs(g, row + dir[0], col + dir[1]);
    }

    class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(int[][] g, int row, int col) {
        final int m = g.length, n = m == 0 ? 0 : g[0].length;

        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(row, col));

        while (!q.isEmpty()) {
            Cell c = q.poll();
            if (c.x < 0 || c.x >= m || c.y < 0 || c.y >= n || g[c.x][c.y] == 0) continue;

            g[c.x][c.y] = 0;
            for (int[] dir : dirs) q.offer(new Cell(c.x + dir[0], c.y + dir[1]));
        }
    }
}
