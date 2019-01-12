package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No827MakingALargeIsland {

    public int largestIsland(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final Map<Integer, Integer> islandSize = new HashMap<>();

        int gid = 1, maxSize = 1, totalSize = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfsMarkGroup(grid, ++gid, i, j);
                    if (size >= totalSize - 1) return totalSize;

                    maxSize = Math.max(maxSize, size);
                    islandSize.put(gid, size);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int newSize = 1;
                    for (int id : getSurroundingIsland(grid, i, j)) newSize += islandSize.get(id);
                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }

        return maxSize;
    }

    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfsMarkGroup(int[][] grid, int gid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) return 0;

        grid[x][y] = gid;
        int count = 1;
        for (int[] dir : dirs) count += dfsMarkGroup(grid, gid, x + dir[0], y + dir[1]);
        return count;
    }

    private Set<Integer> getSurroundingIsland(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int[] dir : dirs) {
            int i = x + dir[0], j = y + dir[1];
            if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] > 1) set.add(grid[i][j]);
        }

        return set;
    }
}
