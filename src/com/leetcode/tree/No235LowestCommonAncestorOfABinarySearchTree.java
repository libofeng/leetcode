package com.leetcode.tree;

public class No235LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null && root.val != p.val && root.val != q.val) {
            if (root.val < Math.min(p.val, q.val)) root = root.right;
            else if (root.val > Math.max(p.val, q.val)) root = root.left;
            else return root;
        }

        return root;
    }
}
