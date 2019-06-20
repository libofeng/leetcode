package com.leetcode.list;

public class No203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;
        dummyHead.next = head;
        while (p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }

        return dummyHead.next;
    }
}
