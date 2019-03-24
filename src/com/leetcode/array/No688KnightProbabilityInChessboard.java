package com.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No688KnightProbabilityInChessboard {
    private int[][] dirs = new int[][]{{-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}, {-2, -1}, {-1, -2}};

    // ---------------- BFS(TLE)---------------
    public double knightProbability(int N, int K, int r, int c) {
        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        int level = K;
        while (level-- > 0 && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] p = q.poll();

                for (int[] dir : dirs) {
                    int x = p[0] + dir[0], y = p[1] + dir[1];
                    if (x < 0 || y < 0 || x >= N || y >= N) continue;
                    q.offer(new int[]{x, y});
                }
            }
        }

        double p = q.size() * 1.0D;
        for (int i = 0; i < K; i++) p /= 8;
        return p;
    }

    // ---------------- DFS(TLE)---------------

    private int remains = 0;

    public double knightProbability2(int N, int K, int r, int c) {
        dfs(N, K, r, c);

        double p = remains * 1.0D;
        for (int i = 0; i < K; i++) p /= 8;
        return p;
    }

    private void dfs(int N, int k, int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N) return;
        if (k == 0) {
            remains++;
            return;
        }

        for (int[] dir : dirs) dfs(N, k - 1, i + dir[0], j + dir[1]);
    }

    // ---------------- DP ---------------
    /*
    类似Out of Boundary Paths.

    DP问题. 求最后在board上的概率. 反过来想，走完K步棋子在board上的哪个位置呢. 反过来走, 看board上所有位置走完K步后能到初始位置(r,c)的数目和.

    储存历史信息是走到当前这步时棋盘上能走到每个位置的不同走法.

    递推时, 向所有方向移动, 若是还在board上就把自己的走法加到新位置的走法上.

    初始化所有位置只有1种走法.

    答案K步之后到初始位置的走法除以Math.pow(8,K).

    Time Complexity: O(K*N^2).

    Space: O(N^2).
     */

    public double knightProbability3(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        for (double[] row : dp) Arrays.fill(row, 1);

        for (int k = 0; k < K; k++) {
            double[][] nextDP = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && y >= 0 && x < N && y < N) {
                            nextDP[x][y] += dp[i][j];
                        }
                    }
                }
            }
            dp = nextDP;
        }

        return dp[r][c] / Math.pow(8, K);
    }

    public static void main(String[] args) {
        No688KnightProbabilityInChessboard solution = new No688KnightProbabilityInChessboard();
        double p = solution.knightProbability3(8, 30, 6, 4);
        System.out.println("p = " + p);
    }
}
