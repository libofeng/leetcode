package com.leetcode.tree;

public class No129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }

    private int preOrder(TreeNode root, int sum) {
        if (root == null) return 0;
        sum *= 10;
        if (root.left == null && root.right == null) return sum + root.val;

        return preOrder(root.left, sum + root.val) + preOrder(root.right, sum + root.val);
    }
}
