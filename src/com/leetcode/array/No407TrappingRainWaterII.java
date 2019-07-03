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

    // the same idea as above.
    public int trapRainWater2(int[][] heightMap) {
        final int m = heightMap.length, n = m == 0 ? 0 : heightMap[0].length;
        int total = 0;
        if (m <= 2 || n <= 2) return total;

        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        final boolean[][] visited = new boolean[m][n];
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i, heightMap[0][i]});
            visited[0][i] = true;
            pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[m - 1][i] = true;
        }

        int max = 0;
        while (!pq.isEmpty()) {
            int i = pq.peek()[0], j = pq.peek()[1], val = pq.poll()[2];
            max = Math.max(max, val);

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;

                total += Math.max(0, max - heightMap[x][y]);
                visited[x][y] = true;
                pq.offer(new int[]{x, y, heightMap[x][y]});
            }
        }

        return total;
    }
}
