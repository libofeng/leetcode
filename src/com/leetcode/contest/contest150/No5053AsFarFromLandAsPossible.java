package com.leetcode.contest.contest150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class No5053AsFarFromLandAsPossible {
    // Time: O(M^2 * N^2), Space: O(MN)
    public int maxDistance(int[][] grid) {
        if (grid.length == 0) return -1;
        final int m = grid.length, n = grid[0].length;

        final List<int[]> land = new ArrayList<>(), water = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) land.add(new int[]{i, j});
                else water.add(new int[]{i, j});
            }
        }

        int distance = -1;
        for (int[] a : water) {
            int min = Integer.MAX_VALUE;
            for (int[] b : land) {
                int d = Math.abs(b[0] - a[0]) + Math.abs(b[1] - a[1]);
                min = Math.min(min, d);
            }

            if (min != Integer.MAX_VALUE) distance = Math.max(distance, min);
        }

        return distance;
    }

    // Time:O(MN), Space: O(MN);
    public int maxDistance2(int[][] grid) {
        if (grid.length == 0) return -1;
        final int m = grid.length, n = grid[0].length;
        final int[][] d = new int[m][n];

        final Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = grid[i][j] == 1 ? 0 : Integer.MAX_VALUE;
                if (d[i][j] == 0) q.add(new int[]{i, j});
            }
        }

        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int px = q.peek()[0], py = q.poll()[1];
            for (int[] dir : dirs) {
                int x = px + dir[0], y = py + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && d[x][y] > d[px][py] + 1) {
                    d[x][y] = d[px][py] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) max = Math.max(max, d[i][j]);
        }
        return max == Integer.MAX_VALUE || max == 0 ? -1 : max;
    }
}
