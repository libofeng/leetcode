package com.leetcode.graph;

public class No261GraphValidTree {
    // https://github.com/interviewdiscussion/files/blob/master/Facebook_java%2Bpdf/261.%20Graph%20Valid%20Tree.java
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {//if we only have 1 node, we should return true;
            return true;
        }
        if (n < 1 || edges == null || edges.length != n - 1 || edges[0] == null || edges[0].length == 0) {
            return false;//edges.length != n - 1? a valid n-node tree should have n - 1 edges
        }
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = -1;//initialize
        }
        for (int[] pair : edges) {//O(edges) time
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x == y) {//which means there is a cycle
                return false;
            }
            roots[x] = y;//union
        }
        return true;
    }

    private int find(int[] roots, int i) {//O(nodes) time, if it's inbalanced
        while (roots[i] != -1) {//should be roots[i], not i !
            i = roots[i];
        }
        return i;
    }


}
