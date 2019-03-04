package com.leetcode.list;

public class No24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head, second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;
        while (p.next != null && p.next.next != null) {
            ListNode first = p.next, second = p.next.next;

            p.next = second;
            first.next = second.next;
            second.next = first;
            p = first;
        }

        head = dummy.next;
        dummy.next = null;
        return head;
    }
}
