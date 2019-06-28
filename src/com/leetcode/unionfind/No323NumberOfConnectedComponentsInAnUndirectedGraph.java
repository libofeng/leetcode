package com.leetcode.unionfind;

public class No323NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int total = n;

        final int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int[] e : edges) {
            int p = find(root, e[0]), q = find(root, e[1]);
            if (p == q) continue;

            root[p] = q;
            total--;
        }

        return total;
    }

    private int find(int[] root, int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }

        return i;
    }
}
