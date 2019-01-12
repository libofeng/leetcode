package com.leetcode.array;

public class No827MakingALargeIsland2 {
    // O(M^2 * N ^ 2)
    public int largestIsland(int[][] grid) {
        final int m = grid.length, n = grid[0].length;

        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    maxSize = Math.max(maxSize, dfsCount(grid, i, j));
                    if (maxSize == m * n) return maxSize;
                    grid[i][j] = 0;
                }
            }
        }

        return maxSize == 0 ? m * n : maxSize;
    }

    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // O(MN)
    private int dfsCount(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) return 0;

        int count = 1;

        grid[x][y] = 2;
        for (int[] dir : dirs) count += dfsCount(grid, x + dir[0], y + dir[1]);
        grid[x][y] = 1;

        return count;
    }

    public static void main(String[] args) {
        No827MakingALargeIsland2 solution = new No827MakingALargeIsland2();
        int size = solution.largestIsland(new int[][]{{1, 1}, {1, 0}});
        System.out.println("size = " + size);
    }
}
