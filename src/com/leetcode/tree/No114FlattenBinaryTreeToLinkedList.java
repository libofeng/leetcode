package com.leetcode.tree;

import java.util.Stack;

public class No114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);
        if (root.left == null) return;

        TreeNode tail = root.left;
        while (tail.right != null) tail = tail.right;

        tail.right = root.right;
        root.right = root.left;
        root.left = null;
    }


    public void flatten2(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode left = node.left, right = node.right, tailL = helper(left), tailR = helper(right);
        node.left = null;

        if (tailL != null) {
            node.right = left;
            tailL.right = right;
        }

        return tailR == null ? tailL : tailR;
    }


    public void flatten3(TreeNode root) {
        if (root == null) return;
        final Stack<TreeNode> stack = new Stack<>();
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);

        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            root.left = null;
            root.right = next;

            if (next.right != null) stack.push(next.right);
            if (next.left != null) stack.push(next.left);
            root = next;
        }
    }


    // preorder: recursion
    TreeNode last;

    public void flatten4(TreeNode root) {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left, right = root.right;
        root.left = null;
        if (last != null) last.right = root;
        last = root;

        preorder(left);
        preorder(right);
    }


    // preorder: stack
    public void flatten5(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            if (last != null) last.right = node;
            node.left = null;
            node.right = null;
            last = node;
        }
    }
}
