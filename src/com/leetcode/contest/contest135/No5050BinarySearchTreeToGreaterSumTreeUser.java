package com.leetcode.contest.contest135;

public class No5050BinarySearchTreeToGreaterSumTreeUser {
    /*
    Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

    As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     */

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        sum = root.val += sum;
        bstToGst(root.left);

        return root;
    }

    public TreeNode bstToGst2(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);

        sum += root.val;
        root.val = sum;

        inorder(root.left);
    }
}
