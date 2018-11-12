package com.lintcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No178GraphValidTree {

    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    //BFS, Time complexity O(N), Space complexity O(N)
    public boolean validTree(int n, int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>(), current = new HashSet<>();
        visited.add(0);
        current.add(0);
        while (!current.isEmpty()) {
            Set<Integer> next = new HashSet<>();

            for (Integer node : current) {
                Set<Integer> pairs = graph.get(node);
                if (pairs == null) continue;
                for (Integer pair : pairs) {
                    if (visited.contains(pair)) return false;
                    graph.get(pair).remove(node);
                    next.add(pair);
                    visited.add(pair);
                }
            }

            current = next;
        }

        return visited.size() == n;
    }


    // DFS
    public boolean validTree2(int n, int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        final Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) return false;

        return n == visited.size();
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int node, int prev) {
        if (visited.contains(node)) return false;
        visited.add(node);
        if (!graph.containsKey(node)) return true;

        for (int next : graph.get(node)) {
            if (next == prev) continue;
            if (!dfs(graph, visited, next, node)) return false;
        }

        return true;
    }

    // Union Find

    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree3(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) return false;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int[] edge : edges) {
            int p = find(root, edge[0]), q = find(root, edge[1]);
            if (p == q) return false;
            root[p] = q;
        }

        return true;
    }

    private int find(int[] root, int n) {
        while (n != root[n]) n = root[n];
        return n;
    }
}
