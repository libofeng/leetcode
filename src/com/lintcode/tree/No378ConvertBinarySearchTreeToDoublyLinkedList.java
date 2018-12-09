package com.lintcode.tree;

public class No378ConvertBinarySearchTreeToDoublyLinkedList {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */

    DoublyListNode head, last;

    public DoublyListNode bstToDoublyList(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        DoublyListNode node = new DoublyListNode(root.val);
        if (last == null) head = node;
        else last.next = node;
        node.prev = last;

        last = node;
        inorder(root.right);
    }
}
