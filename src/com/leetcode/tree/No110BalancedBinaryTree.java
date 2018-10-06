package com.leetcode.tree;

public class No110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) > -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        if (lh < 0) return -1;
        int rh = height(root.right);
        if (rh < 0) return -1;

        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
}
