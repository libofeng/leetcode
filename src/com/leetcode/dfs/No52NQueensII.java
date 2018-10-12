package com.leetcode.dfs;

public class No52NQueensII {
    private int count = 0;

    public int totalNQueens(int n) {
        final int[] C = new int[n];

        dfs(C, 0);

        return count;
    }

    private void dfs(int[] C, int row) {
        final int N = C.length;
        if (row == N) {
            count++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!isValid(C, row, j)) continue;

            C[row] = j;
            dfs(C, row + 1);
        }
    }

    private boolean isValid(int[] C, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (C[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - C[i])) return false;
        }

        return true;
    }
}
