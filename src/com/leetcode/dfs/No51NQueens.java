package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class No51NQueens {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> result = new ArrayList<>();
        dfs(n, 0, result, new int[n]);

        return result;
    }

    private void dfs(int n, int row, List<List<String>> result, int[] queens) {
        if (n == row) {
            StringBuilder sb = new StringBuilder(n);
            final List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb.setLength(0);
                for (int j = 0; j < n; j++) sb.append(j == queens[i] ? 'Q' : '.');
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            queens[row] = i;
            if (isValid(queens, row)) dfs(n, row + 1, result, queens);
        }
    }

    private boolean isValid(int[] queens, int row) {
        final int n = queens.length, col = queens[row];
        for (int i = 0; i < row; i++) {
            if (col == queens[i]) return false;
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }

        return true;
    }
}
