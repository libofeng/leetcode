package com.leetcode.graph;

import java.util.*;

public class No1135ConnectingCitiesWithMinimumCost {
    // Prim
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

    // We use Kruskal’s algorithm to generate a minimum spanning tree for the graph. Use Union-Find to detect cycle.
    // Idea is simple:

    // Sort edges to no-descending order
    // Pick the smallest edge that does not form a cycle
    // Repeat until MST is formed and every node is connected.
    // Implemented Union-Find with path compression to improve efficiency.

    // There are tons of materials online about the proof of correctness and analysis of this algorithm. Feel free to check them around.
    // Time: O(ELogE + ELogN)
    public int minimumCost2(int N, int[][] connections) {
        final int[] parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int costs = 0, groups = N;
        for (int[] e : connections) {
            int a = e[0] - 1, b = e[1] - 1, cost = e[2];
            int p = find(parent, a), q = find(parent, b);
            if (p != q) {
                groups--;
                parent[p] = q;
                costs += cost;
            }
        }

        return groups == 1 ? costs : -1;
    }


    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}
