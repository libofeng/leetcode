package com.leetcode.tree;

public class No814BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = pruneTree(root.left), right = pruneTree(root.right);

        if (left == null) root.left = null;
        if (right == null) root.right = null;

        if (root.val == 0 && left == null && right == null) return null;
        return root;
    }
}
