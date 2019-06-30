package com.leetcode.contest.biweekly.contest3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1102PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        final int m = A.length, n = A[0].length;
        final int[][] score = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(score[i], -1);

        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new int[]{A[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int val = p[0], i = p[1], j = p[2];
            score[i][j] = Math.max(score[i][j], val);

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || score[x][y] >= 0) continue;
                pq.offer(new int[]{Math.min(score[i][j], A[x][y]), x, y});
            }
        }

        return score[m - 1][n - 1];
    }
}
