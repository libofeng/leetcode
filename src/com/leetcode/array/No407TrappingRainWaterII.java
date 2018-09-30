package com.leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No407TrappingRainWaterII {
    class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;
        final PriorityQueue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));

        final int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            q.offer(new Cell(i, 0, heightMap[i][0]));
            q.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            q.offer(new Cell(0, j, heightMap[0][j]));
            q.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int R = 0;
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];

                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    R += Math.max(0, cell.height - heightMap[row][col]);
                    q.offer(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }

        return R;
    }
}
