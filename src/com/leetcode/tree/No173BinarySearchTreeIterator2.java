package com.leetcode.tree;

public class No173BinarySearchTreeIterator2 {
    private TreeNode next, root;

    public No173BinarySearchTreeIterator2(TreeNode root) {
        this.root = root;

        next = root;
        if (next != null) while (next.left != null) next = next.left;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) return -1;

        TreeNode node = next;
        next = successor();
        return node.val;
    }

    private TreeNode successor() {
        TreeNode current = root, node = next, successor = null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }

        while (current != null) {
            if (node.val == current.val) break;
            if (node.val < current.val) {
                successor = current;
                current = current.left;
            } else current = current.right;
        }

        return current == null ? null : successor;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return next != null;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */