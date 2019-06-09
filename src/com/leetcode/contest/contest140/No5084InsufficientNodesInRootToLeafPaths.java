package com.leetcode.contest.contest140;

public class No5084InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return getSum(root, limit, 0) < limit ? null : root;
    }

    private int getSum(TreeNode root, int limit, int pathSum){
        if(root == null) return pathSum;

        pathSum += root.val;
        int left = getSum(root.left, limit, pathSum);
        int right = getSum(root.right, limit, pathSum);

        if(left<limit) root.left = null;
        if(right < limit) root.right = null;

        return Math.max(left, right);
    }
}
