package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        helper(root, R);

        return R;
    }

    private void helper(TreeNode node, List<Integer> R) {
        if (node == null) return;

        helper(node.left, R);
        helper(node.right, R);
        R.add(node.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, prev = null;

        do {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            prev = null;
            while (!stack.isEmpty()) {
                current = stack.pop();

                if (prev == current.right) {
                    R.add(current.val);
                    prev = current;
                } else {
                    stack.push(current);
                    current = current.right;
                    break;
                }
            }

        } while (!stack.isEmpty());

        return R;
    }


    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> R = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root, prev = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (current.right == null || prev == current.right) {
                R.add(current.val);
                prev = current;
                current = null;
            } else {
                stack.push(current);
                current = current.right;
            }
        }

        return R;
    }
}
