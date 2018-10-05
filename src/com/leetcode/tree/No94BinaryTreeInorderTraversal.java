package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        helper(root, R);

        return R;
    }

    private void helper(TreeNode node, List<Integer> R) {
        if (node == null) return;

        helper(node.left, R);
        R.add(node.val);
        helper(node.right, R);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null && current.left != null) {
                stack.push(current);
                current = current.left;
            }

            if (current == null) current = stack.pop();
            R.add(current.val);

            current = current.right;
        }

        return R;
    }
}
