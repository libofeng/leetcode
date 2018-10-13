package com.leetcode.dfs;

public class No79WordSearch {
    final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        final int m = board.length, n = board[0].length;
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                if (dfs(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        final int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return false;

        if (word.charAt(index) == board[i][j] && !visited[i][j]) {
            visited[i][j] = true;
            for (int[] dir : dirs) if (dfs(board, visited, i + dir[0], j + dir[1], word, index + 1)) return true;
            visited[i][j] = false;
        }

        return false;
    }
}
