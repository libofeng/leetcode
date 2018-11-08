package com.leetcode.tree;

public class No236LowestCommonAncestorOfABinaryTree {

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

}
