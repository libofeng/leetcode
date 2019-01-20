package com.leetcode.array;

public class No980UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        int nonObstacles = 0;
        for (int[] rows : grid) for (int c : rows) if (c == 0) nonObstacles++;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, new boolean[m][n], nonObstacles, 0);
                }
            }
        }

        return 0;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int target, int k) {
        final int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (grid[i][j] == 2) return (target == k - 1) ? 1 : 0;
        if (visited[i][j] || grid[i][j] == -1) return 0;

        visited[i][j] = true;
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            count += dfs(grid, x, y, visited, target, k + 1);
        }
        visited[i][j] = false;
        return count;
    }

    public static void main(String[] args) {
        No980UniquePathsIII solution = new No980UniquePathsIII();
        int solutions = solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});
        System.out.println("solutions = " + solutions);
    }
}
