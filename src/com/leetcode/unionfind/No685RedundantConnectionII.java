package com.leetcode.unionfind;

public class No685RedundantConnectionII {
    // https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)

    // a rooted graph add one more edge, there are 2 situations:
    // 1. a node have 2 parents
    // 2. a cycle exist

    // Steps:
    // 1. try to find a node with 2 parents, if exist, set the 1st edge as candidate1, 2nd edge as candidate2
    // 2. a) if the node with 2 parents not found in step #1, there must be a cycle
    //       When the cycle found, if the candidate equals {-1, -1}(the node with 2 parents not found), return the edge cause cycle.
    // 2. b) if the node with 2 parents found in step #1, set the 2nd edge invalid
    //       A) after set the 2nd edge invalid, the graph become a rooted tree, candidate2 is the answer
    //       B) the graph still is not a tree, then we should invalid the 1st edge in step #1, so candidate2 is the answer

    public int[] findRedundantDirectedConnection(int[][] edges) {
        final int n = edges.length;
        final int[] parent = new int[n + 1];

        int[] candidate1 = new int[]{-1, -1}, candidate2 = new int[]{-1, -1};
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[v] == 0) parent[v] = u;
            else {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
                e[1] = 0;
            }
        }

        final int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int[] e : edges) {
            if (e[1] == 0) continue;

            int u = e[0] - 1, v = e[1] - 1;

            if (find(root, u) == v) {
                // cycle
                if (candidate1[0] == -1) return e;
                return candidate1;
            }
            root[v] = u;
        }

        return candidate2;
    }

    private int find(int[] root, int x) {
        while (x != root[x]) {
            root[x] = root[root[x]];
            x = root[x];
        }

        return x;
    }

}
