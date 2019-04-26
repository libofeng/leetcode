package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class No529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        final int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        bfs(board, x, y);
        return board;
    }

    private int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    private void dfs(char[][] board, int x, int y) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'E') return;

        int count = count(board, x, y);
        if (count == 0) {
            board[x][y] = 'B';
            for (int[] dir : dirs) dfs(board, x + dir[0], y + dir[1]);
        } else board[x][y] = (char) (count + '0');
    }

    // mark the cell first to avoid too many data in the q and much more inspection
    private void bfs(char[][] board, int i, int j) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;
        final Queue<int[]> q = new LinkedList<>();
        int c = count(board, i, j);
        if (c > 0) {
            board[i][j] = (char) (c + '0');
            return;
        }

        q.offer(new int[]{i, j});
        board[i][j] = 'B';
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : dirs) {
                int dx = x + dir[0], dy = y + dir[1];
                if (dx < 0 || dy < 0 || dx >= m || dy >= n || board[dx][dy] != 'E') continue;

                int count = count(board, dx, dy);
                if (count == 0) {
                    q.offer(new int[]{dx, dy});
                    board[dx][dy] = 'B';
                } else board[dx][dy] = (char) (count + '0');
            }
        }
    }

    private int count(char[][] board, int i, int j) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;

        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (board[x][y] == 'M') count++;
        }

        return count;
    }
}
