package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No785IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        final int nodes = graph.length;
        final int[] colors = new int[nodes];
        final Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            if (colors[i] != 0) continue;

            q.offer(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int size = q.size();

                while (size-- > 0) {
                    int n = q.poll(), nextColor = -colors[n];
                    for (int next : graph[n]) {
                        if (colors[next] == 0) {
                            colors[next] = nextColor;
                            q.offer(next);
                        } else if (colors[next] != nextColor) return false;
                    }
                }
            }
        }

        return true;
    }
}
