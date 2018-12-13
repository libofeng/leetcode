package com.lintcode.tree;

public class No94BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val, left = helper(root.left), right = helper(root.right);
        sum = Math.max(Math.max(sum, sum + left), sum + right);
        max = Math.max(Math.max(max, sum), root.val + left + right);

        return sum;
    }
}
