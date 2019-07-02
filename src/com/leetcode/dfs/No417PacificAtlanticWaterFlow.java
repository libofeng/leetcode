package com.leetcode.dfs;

import java.util.*;

public class No417PacificAtlanticWaterFlow {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final List<List<Integer>> result = new ArrayList<>();
        if (n == 0) return result;

        final boolean[][] pVisited = new boolean[m][n], aVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pVisited, i, 0, 0);
            dfs(matrix, aVisited, i, n - 1, 0);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, pVisited, 0, i, 0);
            dfs(matrix, aVisited, m - 1, i, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int prev){
        final int m = matrix.length, n = m == 0? 0 : matrix[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || prev>matrix[i][j]) return;

        visited[i][j] = true;
        for(int[] dir : dirs){
            int x = i + dir[0], y = j + dir[1];
            dfs(matrix, visited, x, y, matrix[i][j]);
        }
    }
}
