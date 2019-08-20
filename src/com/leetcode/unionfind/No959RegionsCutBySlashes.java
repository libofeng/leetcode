package com.leetcode.unionfind;

public class No959RegionsCutBySlashes {
    int[] parent;
    private int count, n;

    // https://leetcode.com/problems/regions-cut-by-slashes/discuss/205680/JavaC%2B%2BPython-Split-4-parts-and-Union-Find
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        count = n * n * 4;
        parent = new int[count];
        for (int i = 0; i < count; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) union(g(i, j - 1, 1), g(i, j, 3));

                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 1), g(i, j, 2));
                    union(g(i, j, 0), g(i, j, 3));
                }

                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
            }
        }

        return count;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b) {
        int p = find(a), q = find(b);
        if (p != q) {
            parent[p] = q;
            count--;
        }
    }

    private int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }
}
