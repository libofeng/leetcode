package com.leetcode.dfs;

public class No37SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        final int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    board[i][j] = c;
                    if (isValid(board, i, j) && solve(board)) return true;
                }
                board[i][j] = '.';
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int x, int y) {
        final int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) if (x != i && board[i][y] == board[x][y]) return false;
        for (int j = 0; j < n; j++) if (y != j && board[x][j] == board[x][y]) return false;

        for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
            for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
                if (i != x && j != y && (board[i][j] == board[x][y])) return false;
            }
        }

        return true;
    }
}
