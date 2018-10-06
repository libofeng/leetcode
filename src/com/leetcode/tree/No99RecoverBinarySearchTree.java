package com.leetcode.tree;

public class No99RecoverBinarySearchTree {
    TreeNode prev, p1, p2;

    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(p1, p2);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (p1 == null) p1 = prev;
            p2 = node;
        }
        prev = node;

        inorder(node.right);
    }

    private void swap(TreeNode N1, TreeNode N2) {
        final int tmp = N1.val;
        N1.val = N2.val;
        N2.val = tmp;
    }
}
