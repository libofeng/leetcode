package com.leetcode.tree;

public class No543DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left), right = height(root.right);
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
