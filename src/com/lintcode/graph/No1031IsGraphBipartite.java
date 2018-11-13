package com.lintcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No1031IsGraphBipartite {
    /**
     * @param graph: the given undirected graph
     * @return: return true if and only if it is bipartite
     */
    public boolean isBipartite(int[][] graph) {
        final int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !isValid(graph, colors, 1, i)) return false;
        }

        return true;
    }

    private boolean isValid(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) return colors[node] == color;

        colors[node] = color;
        for (int n : graph[node]) if (!isValid(graph, colors, -color, n)) return false;
        return true;
    }

    public boolean isBipartite2(int[][] graph) {
        final int[] colors = new int[graph.length];
        final Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) continue;

            q.offer(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int node = q.poll();

                for (int n : graph[node]) {
                    if (colors[n] == 0) {
                        colors[n] = -colors[node];
                        q.offer(n);
                    } else if (colors[n] == colors[node]) return false;
                }
            }
        }

        return true;
    }
}
