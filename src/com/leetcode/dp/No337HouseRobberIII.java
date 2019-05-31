package com.leetcode.dp;

public class No337HouseRobberIII {

    public int rob(TreeNode root) {
        return f(root);
    }

    // possible included root
    private int f(TreeNode root) {
        if (root == null) return 0;

        int possibleWithRoot = root.val + g(root.left) + g(root.right);
        int withoutRoot = f(root.left) + f(root.right);

        return Math.max(possibleWithRoot, withoutRoot);
    }

    // excluded root
    private int g(TreeNode root) {
        if (root == null) return 0;

        return f(root.left) + f(root.right);
    }

    public int rob2(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        // f[0]: root included; f[1]:not include root
        int[] f = new int[2];//f,g
        if (root == null) return f;
        int[] l = dfs(root.left), r = dfs(root.right);

        f[1] = l[0] + r[0];
        f[0] = Math.max(l[1] + r[1] + root.val, f[1]);

        return f;
    }
}
