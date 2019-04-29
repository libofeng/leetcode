package com.leetcode.tree;

import java.util.Stack;

public class No783MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private TreeNode prev = null;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null) min = Math.min(min, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }


    public int minDiffInBST2(TreeNode root) {
        int min = Integer.MAX_VALUE;
        final Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null, current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (prev != null) min = Math.min(min, current.val - prev.val);
            prev = current;
            current = current.right;
        }

        return min;
    }
}
