package com.leetcode.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No51NQueens {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> R = new LinkedList<>();
        final int[] C = new int[n];

        dfs(0, C, R);

        return R;
    }

    private void dfs(int row, int[] C, List<List<String>> R) {
        final int N = C.length;
        if (row == N) {
            final List<String> solution = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                final char[] chars = new char[N];
                Arrays.fill(chars, '.');
                for (int j = 0; j < N; j++) if (C[j] == i) chars[j] = 'Q';
                solution.add(new String(chars));
            }

            R.add(solution);
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!isValid(C, row, j)) continue;

            C[row] = j;
            dfs(row + 1, C, R);
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
