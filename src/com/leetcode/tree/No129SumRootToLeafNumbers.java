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

    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;

        int left = dfs(root.left, sum), right = dfs(root.right, sum);
        return left + right;
    }
}
