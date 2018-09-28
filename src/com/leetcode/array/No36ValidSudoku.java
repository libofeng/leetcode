package com.leetcode.array;

import java.util.Arrays;

public class No36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];

        //rows
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);

            for (int j = 0; j < 9; j++) {
                if (!check(board[i][j], used)) return false;
            }
        }


        //columns
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);

            for (int j = 0; j < 9; j++) {
                if (!check(board[j][i], used)) return false;
            }
        }

        // 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(used, false);

                for (int p = i * 3; p < (i + 1) * 3; p++) {
                    for (int q = j * 3; q < (j + 1) * 3; q++) {
                        if (!check(board[p][q], used)) return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean check(char c, boolean[] used) {
        if (c == '.') return true;
        if (used[c - '1']) return false;

        used[c - '1'] = true;
        return true;
    }
}
