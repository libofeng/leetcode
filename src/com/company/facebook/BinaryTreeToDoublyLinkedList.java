package com.company.facebook;


public class BinaryTreeToDoublyLinkedList {
    TreeNode head, last;

    public TreeNode build(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        link(node);
        inorder(node.right);
    }


    private void link(TreeNode node) {
        if (node == null) return;

        node.left = last;
        if (last == null) head = node;
        else last.right = node;

        last = node;
    }
}
