package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No419BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }

        return count;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] board, int i, int j) {
        final int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'X') return;

        board[i][j] = '.';
        for (int[] dir : dirs) dfs(board, i + dir[0], j + dir[1]);
    }

    private void bfs(char[][] board, int i, int j) {
        final int m = board.length, n = board[0].length;
        final Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            board[p[0]][p[1]] = '.';

            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'X') continue;
                q.offer(new int[]{x, y});
            }
        }
    }

    // https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution
    public int countBattleships2(char[][] board) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}
