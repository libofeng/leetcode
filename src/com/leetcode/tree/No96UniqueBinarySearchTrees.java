package com.leetcode.tree;

public class No96UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 1) return 1;

        int count = 0;
        for (int i = 1; i <= n; i++) count += numTrees(i - 1) * numTrees(n - i);
        return count;
    }

    public int numTrees2(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) for (int j = 1; j <= i; j++) f[i] += f[j - 1] * f[i - j];

        return f[n];
    }
}
