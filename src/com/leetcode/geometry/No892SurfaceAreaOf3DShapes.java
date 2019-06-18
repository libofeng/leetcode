package com.leetcode.geometry;

public class No892SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int surface = 0;
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                surface += grid[i][j] * 4 + 2;
                if (i > 0) surface -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                if (j > 0) surface -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
            }
        }

        return surface;
    }
}
