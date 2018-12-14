package com.lintcode.tree;

public class No475BinaryTreeMaximumPathSumII {


    /**
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;

        int left = maxPathSum2(root.left), right = maxPathSum2(root.right);
        return Math.max(Math.max(root.val, root.val + left), root.val + right);
    }


    int max = Integer.MIN_VALUE;

    public int maxPathSum21(TreeNode root) {
        if (root == null) return 0;

        preorder(root, 0);
        return max;
    }

    private void preorder(TreeNode root, int sum) {
        if (root == null) return;

        sum += root.val;
        max = Math.max(max, sum);

        preorder(root.left, sum);
        preorder(root.right, sum);
    }
}
