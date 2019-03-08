package com.leetcode.graph;

public class No785IsGraphBipartite2 {
    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        final int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            if (!dfs(graph, i, colors, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int n, int[] colors, int color) {
        if (colors[n] != 0) return color == colors[n];

        colors[n] = color;
        for (int next : graph[n]) if (!dfs(graph, next, colors, -color)) return false;
        ;

        return true;
    }
}
