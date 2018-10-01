package com.leetcode.list;

public class No19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), p = dummy, parent = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) p = p.next;

        while (p != null) {
            p = p.next;
            parent = parent.next;
        }

        parent.next = parent.next.next;
        return dummy.next;
    }
}
