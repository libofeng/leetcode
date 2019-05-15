package com.leetcode.tree;

import java.util.*;

public class No886PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : dislikes) {
            graph.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        final int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colors[i] > 0) continue;
            if (!bfs(graph, colors, i, 1)) return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, int[] colors, Integer n, int c) {
        if (!g.containsKey(n)) return true;
        if (colors[n] > 0) return colors[n] == c;

        colors[n] = c;
        for (int next : g.get(n)) {
            if (!dfs(g, colors, next, c == 1 ? 2 : 1)) return false;
        }

        return true;
    }

    private boolean bfs(Map<Integer, List<Integer>> g, int[] colors, Integer n, int c) {
        final Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        colors[n] = c;

        while (!q.isEmpty()) {
            int size = q.size();
            c = c == 1 ? 2 : 1;

            while (size-- > 0) {
                int node = q.poll();
                if (!g.containsKey(node)) continue;

                for (int next : g.get(node)) {
                    if (colors[next] > 0) {
                        if (colors[next] != c) return false;
                    } else {
                        colors[next] = c;
                        q.offer(next);
                    }
                }
            }
        }

        return true;
    }
}
