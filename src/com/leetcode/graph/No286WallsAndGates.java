package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No286WallsAndGates {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        final int m = rooms.length, n = m == 0 ? 0 : rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) bfs(rooms, i, j, 0);
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        final int m = rooms.length, n = rooms[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || rooms[i][j] < d) return;

        rooms[i][j] = d;
        for (int[] dir : dirs) dfs(rooms, i + dir[0], j + dir[1], d + 1);
    }

    private void bfs(int[][] rooms, int i, int j, int d) {
        final int m = rooms.length, n = rooms[0].length;
        final Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            i = q.peek()[0];
            j = q.poll()[1];

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] < rooms[i][j] + 1) continue;

                rooms[x][y] = rooms[i][j] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }
}
