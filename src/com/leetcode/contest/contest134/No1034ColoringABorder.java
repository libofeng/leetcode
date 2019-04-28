package com.leetcode.contest.contest134;

public class No1034ColoringABorder {
    // https://leetcode.com/contest/weekly-contest-134/problems/coloring-a-border/

    /*
    1034. Coloring A Border
    User Accepted: 0
    User Tried: 0
    Total Accepted: 0
    Total Submissions: 0
    Difficulty: Medium
    Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.

    Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.

    The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

    Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.



    Example 1:

    Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
    Output: [[3, 3], [3, 2]]
    Example 2:

    Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
    Output: [[1, 3, 3], [2, 3, 3]]
    Example 3:

    Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
    Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]


    Note:

    1 <= grid.length <= 50
    1 <= grid[0].length <= 50
    1 <= grid[i][j] <= 1000
    0 <= r0 < grid.length
    0 <= c0 < grid[0].length
    1 <= color <= 1000
     */

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        final int m = grid.length, n = grid[0].length;

        int val = grid[r0][c0];
        dfs(grid, r0, c0, val);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) continue;
                if (!isBorder(grid, i, j, val)) grid[i][j] = val;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) grid[i][j] = color;
            }
        }

        return grid;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int i, int j, int val) {
        final int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != val) return;

        grid[i][j] = -val;
        for (int[] dir : dirs) dfs(grid, i + dir[0], j + dir[1], val);
    }

    private boolean isBorder(int[][] grid, int i, int j, int val) {
        final int m = grid.length, n = grid[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || Math.abs(grid[x][y]) != val) return true;
        }

        return false;
    }
}
