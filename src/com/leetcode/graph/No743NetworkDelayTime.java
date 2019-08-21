package com.leetcode.graph;

import java.util.*;

public class No743NetworkDelayTime {
    // Bellman-ford
    // Time: O(NE), Space: O(N^2)
    public int networkDelayTime(int[][] times, int N, int K) {
        final int INF = 1000000007;
        final int[][] dp = new int[N + 1][N];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][K - 1] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i][K - 1] = 0;
            for (int[] e : times) {
                int a = e[0] - 1, b = e[1] - 1, w = e[2];
                dp[i][b] = Math.min(dp[i][b], dp[i - 1][a] + w);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) max = Math.max(max, dp[N][i]);
        return max == INF ? -1 : max;
    }

    // Dijkstra
    // Time: O(NLogN + E), Space: O(N + E)
    public int networkDelayTime2(int[][] times, int N, int K) {
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int[] e : times) graph.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});

        final Set<Integer> visited = new HashSet<>();
        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K - 1, 0});

        int max = 0;
        while (!pq.isEmpty()) {
            int n = pq.peek()[0], time = pq.poll()[1];
            if (!visited.add(n)) continue;
            max = Math.max(max, time);

            for (int[] next : graph.get(n)) pq.offer(new int[]{next[0], time + next[1]});
        }

        return visited.size() == N ? max : -1;
    }


    // Floyd-Warshall
    // Time: O(N^3), Space: O(N^2)
    public int networkDelayTime3(int[][] times, int N, int K) {
        final int INF = 100000007;
        final int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) dp[i][j] = i == j ? 0 : INF;
        }
        for (int[] e : times) dp[e[0] - 1][e[1] - 1] = e[2];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) max = Math.max(max, dp[K - 1][i]);
        return max == INF ? -1 : max;
    }

    // refer to:
    // https://leetcode.com/problems/network-delay-time/discuss/183873/Java-solutions-using-Dijkstra-FloydWarshall-and-Bellman-Ford-algorithm
}
