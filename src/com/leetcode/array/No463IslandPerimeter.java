package com.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class No463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return bfs(grid, i, j);
            }
        }

        return 0;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] grid, int i, int j) {
        final int m = grid.length, n = grid[0].length;

        grid[i][j] = -1;
        int sum = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) sum++;
            else if (grid[x][y] == 1) sum += dfs(grid, x, y);
        }
        grid[i][j] = 1;
        return sum;
    }

    private int bfs(int[][] grid, int i, int j) {
        final int m = grid.length, n = grid[0].length;
        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = -1;

        int perimeter = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) perimeter++;
                else if (grid[x][y] == 1) {
                    grid[x][y] = -1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return perimeter;
    }

    public int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    /*
    loop over the matrix and count the number of islands;
    if the current dot is an island, count if it has any right neighbour or down neighbour;
    the result is islands * 4 - neighbours * 2

    Explanation of this elegant solution:
    Only check right and down, because left and up will get checked by a previous element.
    A neighbor subtracts a side from the perimeter.
    But since only count right and down, we have to double count. thus -2*neighbors.

     */
    public static void main(String[] args) {
        No463IslandPerimeter solution = new No463IslandPerimeter();
        int perimeter = solution.islandPerimeter(new int[][]{{1, 1}, {1, 1}});
        System.out.println("perimeter = " + perimeter);
    }
}
