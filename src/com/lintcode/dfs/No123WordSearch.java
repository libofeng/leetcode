package com.lintcode.dfs;

public class No123WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word:  A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;
        final boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (dfs(board, used, word, i, j, 0)) return true;
        }

        return false;
    }

    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(char[][] B, boolean[][] used, String W, int x, int y, int start) {
        if (start == W.length()) return true;
        final int m = B.length, n = B[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || used[x][y] || B[x][y] != W.charAt(start)) return false;

        used[x][y] = true;
        for (int[] dir : dirs) {
            if (dfs(B, used, W, x + dir[0], y + dir[1], start + 1)) return true;
        }
        used[x][y] = false;
        return false;
    }
}
