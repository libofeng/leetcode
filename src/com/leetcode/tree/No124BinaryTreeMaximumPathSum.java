package com.leetcode.tree;

public class No124BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        postorder(root);
        return maxSum;
    }

    private int postorder(TreeNode node){
        if(node == null) return 0;

        int left = postorder(node.left), right = postorder(node.right), sum = node.val;
        if(left>0) sum += left;
        if(right>0) sum += right;
        maxSum = Math.max(maxSum, sum);

        return Math.max(node.val, Math.max(left, right) + node.val);
    }
}
