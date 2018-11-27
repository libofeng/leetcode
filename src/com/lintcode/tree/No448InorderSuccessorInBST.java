package com.lintcode.tree;

public class No448InorderSuccessorInBST {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) return inorderSuccessor(root.right, p);

        TreeNode successor = inorderSuccessor(root.left, p);
        return successor == null ? root : successor;
    }
}
