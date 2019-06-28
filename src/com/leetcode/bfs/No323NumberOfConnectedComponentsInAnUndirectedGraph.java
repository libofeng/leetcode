package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No323NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        final boolean[] visited = new boolean[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, visited, i);
                total++;
            }
        }

        return total;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int n) {
        if (visited[n]) return;

        visited[n] = true;
        for (int next : graph.get(n)) dfs(graph, visited, next);
    }

    private void bfs(List<List<Integer>> graph, boolean[] visited, int n) {
        final Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : graph.get(node)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}
