package com.leetcode.graph;

import java.util.Arrays;

public class No568MaximumVacationDays {
    int maxVacation = 0;


    // Time: O(N^K), Space: O(K)
   // K: weeks, N: cities
    // TLE
    public int maxVacationDays(int[][] flights, int[][] days) {
        dfs(flights, days, 0, 0, 0);
        return maxVacation;
    }

    private void dfs(int[][] flights, int[][] days, int city, int week, int sum) {
        if (week == days[0].length) {
            maxVacation = Math.max(maxVacation, sum);
            return;
        }

        for (int dst = 0; dst < flights.length; dst++) {
            if (city == dst || flights[city][dst] == 1) {
                dfs(flights, days, dst, week + 1, sum + days[dst][week]);
            }
        }
    }

    public static void main(String[] args) {
        No568MaximumVacationDays solution = new No568MaximumVacationDays();
        int maxVacation = solution.maxVacationDays2(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new int[][]{{1, 1, 1}, {7, 7, 7}, {7, 7, 7}});
        System.out.println("maxVacation = " + maxVacation);
    }

    // 2-DP
    // Time:O(K*N ^2), Space: O(KN)
    public int maxVacationDays2(int[][] flights, int[][] days) {
        final int N = flights.length, K = days[0].length;
        final int[][] dp = new int[K + 1][N];
        for (int i = 0; i <= K; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0;

        int maxVacation = 0;
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                int maxDays = Integer.MIN_VALUE;
                for (int j = 0; j < N; j++) {
                    if ((i == j && dp[k - 1][j] != Integer.MIN_VALUE) || flights[j][i] == 1) {
                        maxDays = Math.max(maxDays, dp[k - 1][j] + days[i][k - 1]);
                    }
                }
                dp[k][i] = maxDays;
                if (k == K) maxVacation = Math.max(maxVacation, maxDays);
            }
        }

        return maxVacation;
    }

    // 2-DP -> 1-DP
    // Time:O(K*N ^2), Space: O(N)
    public int maxVacationDays3(int[][] flights, int[][] days) {
        final int N = flights.length, K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        int maxVacation = 0;
        for (int k = 1; k <= K; k++) {
            int[] next = new int[N];

            for (int i = 0; i < N; i++) {
                int maxDays = Integer.MIN_VALUE;
                for (int j = 0; j < N; j++) {
                    if ((i == j && dp[j] != Integer.MIN_VALUE) || flights[j][i] == 1) {
                        maxDays = Math.max(maxDays, dp[j] + days[i][k - 1]);
                    }
                }
                next[i] = maxDays;
                if (k == K) maxVacation = Math.max(maxVacation, maxDays);
            }
            dp = next;
        }

        return maxVacation;
    }
}
