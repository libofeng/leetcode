package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51NQueens {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> result = new ArrayList<>();
        final int[] queenColumn = new int[n];

        dfs(n, queenColumn, result, 0);

        return result;
    }

    private void dfs(int n, int[] queenColumn, List<List<String>> result, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[queenColumn[i]] = 'Q';
                solution.add(new String(line));
            }
            result.add(solution);

            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(n, queenColumn, row, col)) continue;
            queenColumn[row] = col;
            dfs(n, queenColumn, result, row + 1);
        }
    }

    private boolean isValid(int n, int[] queenColumn, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queenColumn[i] == col) return false; // the same column
            if (Math.abs(row - i) == Math.abs(col - queenColumn[i])) return false; // the same diagonal
        }

        return true;
    }
}
