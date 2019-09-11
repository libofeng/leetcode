package com.leetcode.graph;

public class No839SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        final int n = A.length;

        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;

                String a = A[i], b = A[j];
                if (isSimilar(a, b)) uf.union(i, j);
            }
        }

        return uf.groups;
    }

    private boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++count > 2) return false;
        }

        return true;
    }

    class UnionFind {
        int n, groups;
        int[] parent;

        UnionFind(int n) {
            this.n = n;

            groups = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        void union(int a, int b) {
            int p = find(a), q = find(b);

            if (p != q) {
                parent[p] = q;
                groups--;
            }
        }
    }
}
