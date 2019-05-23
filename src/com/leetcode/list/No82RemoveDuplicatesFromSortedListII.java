package com.leetcode.list;

public class No82RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val == head.next.val) {
            ListNode next = head.next;
            while (next != null && next.val == head.val) next = next.next;
            return deleteDuplicates(next);
        }

        head.next = deleteDuplicates(head.next);
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;

        while (head != null) {
            ListNode next = head.next;
            while (next != null && next.val == head.val) next = next.next;

            if (next == head.next) {
                head.next = null;

                p.next = head;
                p = p.next;
            }

            head = next;
        }

        return dummyHead.next;
    }
}
