package com.leetcode.tree;

import java.util.Stack;

public class No404SumOfLeftLeaves {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean left) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (left) sum += root.val;
            return;
        }

        dfs(root.left, true);
        dfs(root.right, false);
    }

    // Stack
    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        final Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return sum;
    }

    // we can also use Queue or Morris traversal

}
