package com.leetcode.tree;

public class No426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    private TreeNode head, last;

    public TreeNode convert(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (last == null) head = root;
        else {
            root.left = last;
            last.right = root;
        }
        last = root;

        inorder(root.right);
    }

    public static void main(String[] args) {
        No426ConvertBinarySearchTreeToSortedDoublyLinkedList solution = new No426ConvertBinarySearchTreeToSortedDoublyLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode head = solution.convert(root);
        System.out.println("head = " + head);
    }
}
