package com.leetcode.tree;

public class No124BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        postorder(root);
        return maxSum;
    }

    private int postorder(TreeNode root) {
        if (root == null) return 0;

        int left = postorder(root.left), right = postorder(root.right);
        int sum = root.val + Math.max(0, left) + Math.max(0, right);
        maxSum = Math.max(maxSum, sum);

        return Math.max(root.val, Math.max(left, right) + root.val);
    }
}
