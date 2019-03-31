package com.leetcode.tree;

public class No285InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (p.val >= root.val) return inorderSuccessor(root.right, p);

        TreeNode successor = inorderSuccessor(root.left, p);
        return successor == null ? root : successor;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode successor = null, current = root;

        while (current != null) {
            if (current.val == p.val) break;

            if (p.val < current.val) {
                successor = current;
                current = current.left;
            } else current = current.right;
        }

        if (current == null) return null;
        if (current.right == null) return successor;

        current = current.right;
        while (current.left != null) current = current.left;

        return current;
    }
}
