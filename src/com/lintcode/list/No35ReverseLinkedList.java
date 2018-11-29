package com.lintcode.list;

public class No35ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode next = head.next, newHead = reverse(next);
        head.next = null;
        next.next = head;

        return newHead;
    }
}
