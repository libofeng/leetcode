package com.leetcode.list;

public class No24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), current = dummy;

        while (head != null) {
            if (head.next == null) {
                current.next = head;
                break;
            } else {
                ListNode node = head, next = head.next;
                head = next.next;

                node.next = null;
                next.next = node;
                current.next = next;
                current = node;
            }
        }

        return dummy.next;
    }
}
