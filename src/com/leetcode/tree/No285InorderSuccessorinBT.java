package com.leetcode.tree;

import java.util.Stack;

public class No285InorderSuccessorinBT {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        final Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (prev != null && prev.val == p.val) return current;
            prev = current;

            current = current.right;
        }

        return null;
    }

    private TreeNode prev, successor;

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        inorder(root, p);
        return successor;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);

        if (prev != null && prev.val == p.val && successor == null) {
            successor = root;
            return;
        }
        prev = root;

        inorder(root.right, p);
    }
}
