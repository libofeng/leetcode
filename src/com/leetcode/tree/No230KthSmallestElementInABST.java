package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;
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

    // ---------------------------


    Map<TreeNode, Integer> cache = new HashMap<>();

    public int kthSmallest2(TreeNode root, int k) {
        int c = count(root.left);
        if (c + 1 == k) return root.val;
        return k <= c ? kthSmallest(root.left, k) : kthSmallest(root.right, k - c - 1);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;

        int c = count(node.left) + count(node.right) + 1;
        cache.put(node, c);
        return c;
    }
}
