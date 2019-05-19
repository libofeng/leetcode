package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No909SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length, total = m * n;
        final boolean[] visited = new boolean[total];
        final Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[0] = true;

        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int index = q.poll();

                for (int i = 1; i <= 6; i++) {
                    int next = index + i;
                    int[] p = getPosition(m, n, next - 1);
                    if (board[p[0]][p[1]] >= 0) next = board[p[0]][p[1]];

                    if (next == total) return moves + 1;
                    if (next > total || visited[next - 1]) continue;

                    visited[next - 1] = true;
                    q.offer(next);
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getPosition(int rows, int cols, int index) {
        int x = rows - index / cols - 1;
        int y = index % cols;
        if (index / cols % 2 == 1) y = cols - y - 1;

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        No909SnakesAndLadders solution = new No909SnakesAndLadders();
        int moves = solution.snakesAndLadders(new int[][]{{-1, -1, 2, -1}, {14, 2, 12, 3}, {4, 9, 1, 11}, {-1, 2, 1, 16}});
//        int moves = solution.snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}});
        System.out.println("moves = " + moves);
    }
}
