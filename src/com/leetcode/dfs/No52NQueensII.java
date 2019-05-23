package com.leetcode.dfs;

public class No52NQueensII {
    private int count = 0;

    // Time: O(N!)
    public int totalNQueens(int n) {
        final int[] queens = new int[n];
        dfs(queens, 0);
        return count;
    }

    private void dfs(int[] queens, int row) {
        final int N = queens.length;
        if (row == N) {
            count++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!isValid(queens, row, j)) continue;

            queens[row] = j;
            dfs(queens, row + 1);
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }

        return true;
    }
}
