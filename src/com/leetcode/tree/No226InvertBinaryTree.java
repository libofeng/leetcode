package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class No226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        final TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        final Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            final TreeNode node = q.poll(), left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return root;
    }
}
