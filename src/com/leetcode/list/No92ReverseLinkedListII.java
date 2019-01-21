package com.leetcode.list;

public class No92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;

        ListNode dummyHead = new ListNode(0), prev = dummyHead;
        dummyHead.next = head;

        for (int i = 1; i < m; i++) prev = prev = prev.next;
        ListNode subHead = prev.next;

        for (int i = 0; i < n - m; i++) {
            ListNode node = subHead.next;
            subHead.next = subHead.next.next;

            node.next = prev.next;
            prev.next = node;
        }

        head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }
}
