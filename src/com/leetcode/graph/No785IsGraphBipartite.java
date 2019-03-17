package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No785IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        final int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            if (!bfs(graph, colors, i, 1)) return false;
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] != 0) return colors[i] == color;

        colors[i] = color;
        for (int next : graph[i]) if (!dfs(graph, colors, next, -color)) return false;
        return true;
    }

    private boolean bfs(int[][] graph, int[] colors, int i, int color) {
        final Queue<Integer> q = new LinkedList<>();
        colors[i] = color;
        q.offer(i);

        while (!q.isEmpty()) {
            int size = q.size();
            color = -color;
            while (size-- > 0) {
                int n = q.poll();
                for (int next : graph[n]) {
                    if (colors[next] == 0) {
                        colors[next] = color;
                        q.offer(next);
                    } else if (colors[next] != color) return false;

                }
            }
        }

        return true;
    }
}
