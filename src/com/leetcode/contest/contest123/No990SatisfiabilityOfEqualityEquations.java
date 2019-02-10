package com.leetcode.contest.contest123;

public class No990SatisfiabilityOfEqualityEquations {
    private int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (String s : equations) {
            int a = s.charAt(0) - 'a', b = s.charAt(3) - 'a';
            if (s.charAt(1) == '=') union(a, b);
        }

        for (String s : equations) {
            int a = s.charAt(0) - 'a', b = s.charAt(3) - 'a';
            if (s.charAt(1) == '!' && find(a) == find(b)) return false;
        }

        return true;
    }

    private void union(int p, int q) {
        int pr = find(p), qr = find(q);
        if (pr == qr) return;

        parent[pr] = qr;
    }

    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }
}
