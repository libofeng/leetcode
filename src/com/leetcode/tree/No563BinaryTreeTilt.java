package com.leetcode.tree;

public class No563BinaryTreeTilt {
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left), right = sum(root.right);

        tilt += Math.abs(left - right);
        return root.val + left + right;
    }
}
