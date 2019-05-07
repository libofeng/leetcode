package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No1030MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        final boolean[][] visited = new boolean[R][C];
        final int[][] result = new int[R * C][2];
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        final Queue<int[]> q = new LinkedList<>();

        int index = 0;
        int[] cell = new int[]{r0, c0};
        q.offer(cell);
        visited[r0][c0] = true;
        result[index++] = cell;

        while (!q.isEmpty()) {
            cell = q.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0], y = cell[1] + dir[1];
                if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y]) continue;

                visited[x][y] = true;
                int[] next = new int[]{x, y};
                result[index++] = next;
                q.offer(next);
            }
        }

        return result;
    }
}
