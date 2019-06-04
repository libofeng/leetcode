package com.leetcode.tree;

import java.util.Stack;

public class No1038BinarySearchTreeToGreaterSumTree {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);

        return root;
    }


    public TreeNode bstToGst2(TreeNode root) {
        int sum = 0;
        final Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            sum += current.val;
            current.val = sum;

            current = current.left;
        }

        return root;
    }
}
