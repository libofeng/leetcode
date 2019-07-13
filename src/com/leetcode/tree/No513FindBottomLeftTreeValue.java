package com.leetcode.tree;

public class No513FindBottomLeftTreeValue {
    private int depth, val;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return val;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) return;

        dfs(root.left, d + 1);
        if (d > depth) {
            val = root.val;
            depth = d;
        }
        dfs(root.right, d + 1);
    }
}
