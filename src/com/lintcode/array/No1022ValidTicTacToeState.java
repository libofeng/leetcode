package com.lintcode.array;

public class No1022ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int countX = count(board, 'X'), countO = count(board, 'O');
        if (countO > countX || Math.abs(countO - countX) > 1) return false;

        boolean xWin = findWin(board, 'X'), oWin = findWin(board, 'O');
        if (xWin && countO >= countX) return false;
        if (oWin && countX > countO) return false;

        return true;
    }

    private boolean findWin(String[] board, char c) {
        // row
        for (String row : board) {
            if (row.charAt(0) == c && row.charAt(1) == c && row.charAt(2) == c) return true;
        }

        // col
        for (int col = 0; col < 3; col++) {
            if (board[0].charAt(col) == c && board[1].charAt(col) == c && board[2].charAt(col) == c) return true;
        }

        // diagonal
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c) return true;

        return false;
    }

    private int count(String[] board, char c) {
        int count = 0;
        for (String row : board) {
            for (int i = 0; i < row.length(); i++) if (row.charAt(i) == c) count++;
        }

        return count;
    }
}
