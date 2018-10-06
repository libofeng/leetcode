package com.leetcode.tree;

import java.util.Stack;

public class No173BinarySearchTreeIterator {
    final Stack<TreeNode> stack = new Stack<>();

    public No173BinarySearchTreeIterator(TreeNode root) {
        findNext(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) findNext(node.right);

        return node.val;
    }

    private void findNext(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */