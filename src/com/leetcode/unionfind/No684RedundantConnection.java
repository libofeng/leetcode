package com.leetcode.unionfind;

public class No684RedundantConnection {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        final int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            int a = e[0] - 1, b = e[1] - 1;
            int p = find(a), q = find(b);

            if (p == q) return e;
            parent[p] = q;
        }

        return edges[n - 1];
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
