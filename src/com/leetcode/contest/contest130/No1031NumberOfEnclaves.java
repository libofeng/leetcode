package com.leetcode.contest.contest130;

public class No1031NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        final int m = A.length, n = m == 0 ? 0 : A[0].length;

        for (int i = 0; i < m; i++) dfs(A, i, 0);
        for (int i = 0; i < m; i++) dfs(A, i, n - 1);
        for (int i = 0; i < n; i++) dfs(A, 0, i);
        for (int i = 0; i < n; i++) dfs(A, m - 1, i);

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (A[i][j] == 1) total++;
        }

        return total;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] A, int i, int j) {
        final int m = A.length, n = A[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || A[i][j] == 0) return;

        A[i][j] = 0;
        for (int[] dir : dirs) dfs(A, i + dir[0], j + dir[1]);
    }
}
