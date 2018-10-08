package com.leetcode.tree;

public class No124BinaryTreeMaximumPathSum {
    int maxLen = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);

        return maxLen;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int l = postOrder(root.left), r = postOrder(root.right);
        int max = root.val;
        if (l > 0) max += l;
        if (r > 0) max += r;
        maxLen = Math.max(maxLen, max);

        return l > 0 || r > 0 ? root.val + Math.max(l, r) : root.val;
    }

}
