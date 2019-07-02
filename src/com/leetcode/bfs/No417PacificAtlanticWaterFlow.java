package com.leetcode.bfs;

import java.util.*;

public class No417PacificAtlanticWaterFlow {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final List<List<Integer>> result = new ArrayList<>();
        if (n == 0) return result;

        final boolean[][] pVisited = new boolean[m][n], aVisited = new boolean[m][n];
        final Queue<int[]> pq = new LinkedList<>(), aq = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
            pVisited[i][0] = true;
            aq.offer(new int[]{i, n - 1});
            aVisited[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i});
            pVisited[0][i] = true;
            aq.offer(new int[]{m - 1, i});
            aVisited[m - 1][i] = true;
        }

        bfs(matrix, m, n, pVisited, pq);
        bfs(matrix, m, n, aVisited, aq);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    private void bfs(int[][] matrix, int m, int n, boolean[][] visited, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int i = q.peek()[0], j = q.poll()[1];
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;
                if (matrix[i][j] > matrix[x][y]) continue;

                visited[x][y] = true;
                q.offer(new int[]{x, y});
            }
        }
    }
}
