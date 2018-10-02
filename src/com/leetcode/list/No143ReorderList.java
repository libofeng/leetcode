package com.leetcode.list;

public class No143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;

        // find the middle point, seperate to two lists
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second
        ListNode secondHead = slow.next;
        if (fast.next != null) fast = fast.next;
        slow.next = null;
        reverse(secondHead);
        secondHead = fast;
        // combine together
        while (secondHead != null) {
            ListNode nextHead = head.next;
            ListNode nextSecondHead = secondHead.next;
            head.next = secondHead;
            secondHead.next = nextHead;
            head = nextHead;
            secondHead = nextSecondHead;
        }

    }

    private ListNode reverse(ListNode root) {
        if (root.next == null) return root;
        ListNode next = reverse(root.next);
        next.next = root;
        root.next = null;
        return root;
    }
}
