package com.leetcode.tree;

import java.util.Stack;

public class No98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;

        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }


    TreeNode prev = null;

    public boolean isValidBST2(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;
        if (!inorder(root.left)) return false;

        if (prev != null && prev.val >= root.val) return false;
        prev = root;

        return inorder(root.right);
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root, prev = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (prev != null && prev.val >= current.val) return false;
            prev = current;
            current = current.right;
        }

        return true;
    }
}
