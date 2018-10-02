package com.leetcode.list;

public class No25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        while (prev.next != null) {
            ListNode subHead = prev.next, subTail = subHead;
            for (int i = 1; i < k && subTail != null; i++) subTail = subTail.next;
            if (subTail == null) break;

            prev.next = null;
            ListNode next = subTail.next;
            subTail.next = null;

            reverse(subHead);

            prev.next = subTail;
            subHead.next = next;
            prev = subHead;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = reverse(head.next);
        next.next = head;
        head.next = null;

        return head;
    }
}
