package com.leetcode.tree;

public class No109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        final TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST2(head);
        }
        root.right = sortedListToBST2(slow.next);

        if (prev != null) prev.next = slow;
        return root;
    }
}
