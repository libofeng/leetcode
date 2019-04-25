package com.leetcode.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No694NumberOfDistinctIslands {
    /*
694.Number of Distinct Islands
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
     */

    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        final Set<String> islands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;

                StringBuilder builder = new StringBuilder();
                dfs(grid, i, j, i, j, builder);
                // bfs(grid, i, j, builder);
                islands.add(builder.toString());
            }
        }

        return islands.size();
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int px, int py, int i, int j, StringBuilder builder) {
        final int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 0;
        builder.append(i - px);
        builder.append(j - py);

        for (int[] dir : dirs) dfs(grid, px, py, i + dir[0], j + dir[1], builder);
    }

    private void bfs(int[][] grid, int px, int py, StringBuilder builder) {
        final int m = grid.length, n = grid[0].length;

        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{px, py});
        grid[px][py] = 0;

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            builder.append(cell[0] - px);
            builder.append(cell[1] - py);

            for (int[] dir : dirs) {
                int x = cell[0] + dir[0], y = cell[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) continue;

                q.offer(new int[]{x, y});
                grid[x][y] = 0;
            }
        }
    }
}
