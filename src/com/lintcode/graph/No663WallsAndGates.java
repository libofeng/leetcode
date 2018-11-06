package com.lintcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No663WallsAndGates {

    // reference: https://www.cnblogs.com/grandyang/p/5285868.html

    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        final int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
        }
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] rooms, int row, int col, int val) {
        final int m = rooms.length, n = rooms[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] < val) return;

        rooms[row][col] = val;
        for (int[] dir : dirs) dfs(rooms, row + dir[0], col + dir[1], val + 1);
    }

    // -----------------------------------


    public void wallsAndGates2(int[][] rooms) {
        final int m = rooms.length, n = rooms[0].length;
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (rooms[i][j] == 0) q.offer(new int[]{i, j});
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            int nextVal = rooms[pos[0]][pos[1]] + 1;
            for (int[] dir : dirs) {
                int x = dir[0] + pos[0], y = dir[1] + pos[1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] < nextVal) continue;

                rooms[x][y] = nextVal;
                q.offer(new int[]{x, y});
            }
        }
    }
}
