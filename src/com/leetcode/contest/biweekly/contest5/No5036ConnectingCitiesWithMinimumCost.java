package com.leetcode.contest.biweekly.contest5;

import java.util.*;

public class No5036ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] conections) {
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int[] e : conections) {
            graph.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});
            graph.get(e[1] - 1).add(new int[]{e[0] - 1, e[2]});
        }

        final Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        final Set<Integer> visited = new HashSet<>();
        q.offer(new int[]{0, 0});

        int costs = 0;
        while (!q.isEmpty()) {
            int n = q.peek()[0], cost = q.poll()[1];
            if (!visited.add(n)) continue;
            costs += cost;

            for (int[] next : graph.get(n)) q.offer(next);
        }

        return visited.size() == N ? costs : -1;
    }
}
