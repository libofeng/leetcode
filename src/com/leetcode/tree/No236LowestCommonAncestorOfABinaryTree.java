package com.leetcode.tree;

public class No236LowestCommonAncestorOfABinaryTree {
    // https://segmentfault.com/a/1190000009429876

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        if (left != null && left.val != p.val && left.val != q.val) return left; // optimization

        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        return left != null && right != null ? root : (right == null ? left : right);
    }

}
