package com.leetcode.tree;

import java.util.Stack;

public class No230KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        final Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (root == null) {
                root = stack.pop();
                if (--k == 0) return root.val;
            }

            root = root.right;
        }

        return -1;
    }
}
