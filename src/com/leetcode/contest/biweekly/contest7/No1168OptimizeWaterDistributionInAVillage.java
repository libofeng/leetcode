package com.leetcode.contest.biweekly.contest7;

import java.util.*;

public class No1168OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : pipes) {
            graph.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});
            graph.get(e[1] - 1).add(new int[]{e[0] - 1, e[2]});
        }

        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) pq.offer(new int[]{i, wells[i]});

        final Set<Integer> visited = new HashSet<>();

        int cost = 0;
        while (!pq.isEmpty()) {
            int w = pq.peek()[0], c = pq.poll()[1];
            if (!visited.add(w)) continue;

            cost += c;
            for (int[] next : graph.get(w)) {
                int nextCost = Math.min(next[1], wells[next[0]]);
                pq.offer(new int[]{next[0], nextCost});
            }
        }

        return cost;
    }
}
