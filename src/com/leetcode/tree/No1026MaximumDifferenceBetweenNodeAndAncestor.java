package com.leetcode.tree;

public class No1026MaximumDifferenceBetweenNodeAndAncestor {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root != null) preorder(root, root.val, root.val);

        return maxDiff;
    }

    private void preorder(TreeNode root, int max, int min) {
        if (root == null) return;

        maxDiff = Math.max(maxDiff, Math.abs(max - root.val));
        maxDiff = Math.max(maxDiff, Math.abs(min - root.val));

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        preorder(root.left, max, min);
        preorder(root.right, max, min);
    }
}
