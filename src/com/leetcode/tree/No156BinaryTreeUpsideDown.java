package com.leetcode.tree;

public class No156BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left), parent = root.left;
        parent.left = root.right;
        parent.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }
}
