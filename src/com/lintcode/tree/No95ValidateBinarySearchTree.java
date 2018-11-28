package com.lintcode.tree;

public class No95ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long lo, long hi) {
        if (root == null) return true;

        if (root.val >= hi || root.val <= lo) return false;
        return validate(root.left, lo, root.val) && validate(root.right, root.val, hi);
    }
}
