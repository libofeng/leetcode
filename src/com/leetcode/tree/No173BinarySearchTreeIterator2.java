package com.leetcode.tree;

public class No173BinarySearchTreeIterator2 {
    private TreeNode next, root;

    public No173BinarySearchTreeIterator2(TreeNode root) {
        this.root = root;

        next = root;
        while (next != null && next.left != null) next = next.left;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return next != null;
    }

    private TreeNode successor(TreeNode p) {
        TreeNode successor = null, current = root;
        while (current != null) {
            if (p.val == current.val) break;
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

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) return -1;

        int val = next.val;
        next = successor(next);

        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */