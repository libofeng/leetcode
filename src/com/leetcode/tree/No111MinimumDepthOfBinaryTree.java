package com.leetcode.tree;

public class No111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left), right = minDepth(root.right);

        if (left == 0 || right == 0) return (left == 0 ? right : left) + 1;
        return Math.min(left, right) + 1;
    }
}
