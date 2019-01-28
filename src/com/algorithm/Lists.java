package com.algorithm;


public class Lists {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head.next, newHead = reverse(head.next);
        head.next = null;
        tail.next = head;

        return newHead;
    }

    // l1 and l2 sorted
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = merge(head.next, head == l1 ? l2 : l1);

        return head;
    }
}
