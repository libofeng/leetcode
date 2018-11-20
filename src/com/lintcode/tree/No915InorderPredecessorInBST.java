package com.lintcode.tree;

public class No915InorderPredecessorInBST {
    /**
     * @param root: the given BST
     * @param p:    the given node
     * @return the in-order predecessor of the given node in the BST
     * @see No689TwoSumIVInputIsABST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null, current = root;
        while (current != null) {
            if (current.val == p.val) break;
            if (p.val > current.val) {
                predecessor = current;
                current = current.right;
            } else current = current.left;
        }

        if (current == null) return null;
        if (current.left == null) return predecessor;

        current = current.left;
        while (current.right != null) current = current.right;
        return current;
    }
}
