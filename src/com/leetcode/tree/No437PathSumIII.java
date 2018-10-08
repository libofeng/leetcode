package com.leetcode.tree;

public class No437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return samePathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int samePathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + samePathSum(root.left, sum - root.val) + samePathSum(root.right, sum - root.val);
    }
}
