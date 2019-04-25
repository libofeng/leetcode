package com.leetcode.tree;

import java.util.*;

public class No261GraphValidTree {
    // https://www.cnblogs.com/grandyang/p/5257919.html


    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int[] edge : edges) {
            int p = find(root, edge[0]), q = find(root, edge[1]);
            if (p == q) return false;
            root[p] = q;
            n--;
        }

        return n == 1;
    }

    private int find(int[] root, int n) {
        while (n != root[n]) n = root[n];
        return n;
    }

    // BFS
    public boolean validTree2(int n, int[][] edges) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        final Queue<Integer> q = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (int v : graph.get(node)) {
                if (visited.contains(v)) return false;
                graph.get(v).remove(node);
                q.offer(v);
                visited.add(v);
            }
        }

        return visited.size() == n;
    }

    public boolean validTree3(int n, int[][] edges) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        final Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) return false;

        return visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> graph, Set<Integer> visited, int node, int prev) {
        if (visited.contains(node)) return false;
        visited.add(node);

        for (int v : graph.get(node)) {
            if (v == prev) continue;
            if (!dfs(graph, visited, v, node)) return false;
        }

        return true;
    }
}
