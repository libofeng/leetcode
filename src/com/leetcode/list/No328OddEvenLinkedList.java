package com.leetcode.list;

public class No328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0), current = head, tail = dummy;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = next.next;

            next.next = null;
            tail.next = next;
            tail = next;

            if (current.next != null) current = current.next;
        }
        current.next = dummy.next;
        dummy.next = null;

        return head;
    }
}
