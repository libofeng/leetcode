package com.leetcode.contest.contest140;

public class No5084InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root.val < limit ? null : root;

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return root.left == root.right ? null : root;
    }

    public TreeNode sufficientSubset2(TreeNode root, int limit) {
        return getSum(root, limit, 0) < limit ? null : root;
    }

    private int getSum(TreeNode root, int limit, int pathSum) {
        if (root == null) return Integer.MIN_VALUE;

        pathSum += root.val;
        if (root.left == null && root.right == null) return pathSum;

        int left = getSum(root.left, limit, pathSum);
        int right = getSum(root.right, limit, pathSum);

        if (left < limit) root.left = null;
        if (right < limit) root.right = null;

        return Math.max(left, right);
    }
}
