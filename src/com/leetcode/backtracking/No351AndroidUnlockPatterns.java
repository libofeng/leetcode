package com.leetcode.backtracking;

public class No351AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        final int[][] skip = buildSkipMapping();

        int total = 0;
        final boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {
            total += dfs(skip, visited, 1, i - 1) * 4; // 1, 3, 7, 9
            total += dfs(skip, visited, 2, i - 1) * 4; // 2, 4, 6, 8
            total += dfs(skip, visited, 5, i - 1);
        }

        return total;
    }

    private int dfs(int[][] skip, boolean[] visited, int current, int left) {
        if (left < 0) return 0;
        if (left == 0) return 1;

        visited[current] = true;
        int total = 0;
        for (int i = 1; i < 10; i++) {
            if (!visited[i] && (skip[current][i] == 0 || visited[skip[current][i]])) {
                total += dfs(skip, visited, i, left - 1);
            }
        }
        visited[current] = false;

        return total;
    }

    private int[][] buildSkipMapping() {
        final int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = 5;
        skip[2][8] = skip[8][2] = 5;
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;

        return skip;
    }
}
