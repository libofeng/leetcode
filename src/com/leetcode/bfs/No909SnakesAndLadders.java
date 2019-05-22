package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No909SnakesAndLadders {

    public static void main(String[] args) {
        No909SnakesAndLadders solution = new No909SnakesAndLadders();
        int moves = solution.snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}});
//        int moves = solution.snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}});
        System.out.println("moves = " + moves);
    }

    private int[] getPosition(int rows, int cols, int index) {
        int x = rows - index / cols - 1;
        int y = index % cols;
        if (index / cols % 2 == 1) y = cols - y - 1;

        return new int[]{x, y};
    }

    public int snakesAndLadders(int[][] board) {
        final int m = board.length, n = m == 0 ? 0 : board[0].length, total = m * n;

        final Queue<Integer> q = new LinkedList<>();
        final boolean[] visited = new boolean[total];
        q.offer(1);
        visited[0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int index = q.poll();
                if (index == total) return steps;

                for (int i = 1; i <= 6 && index + i <= total; i++) {
                    int next = index + i;

                    int[] p = getPosition(m, n, next - 1);
                    if (board[p[0]][p[1]] > 0) next = board[p[0]][p[1]];

                    if (visited[next - 1]) continue;
                    visited[next - 1] = true;

                    q.offer(next);
                }
            }
            steps++;
        }

        return -1;
    }
}
