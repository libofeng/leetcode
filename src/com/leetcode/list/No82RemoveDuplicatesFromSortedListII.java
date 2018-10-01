package com.leetcode.list;

public class No82RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0), tail = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int duplicateValue = head.val;
                while (head != null && head.val == duplicateValue) head = head.next;
            } else {
                ListNode node = head;
                head = head.next;
                node.next = null;

                tail.next = node;
                tail = node;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && next.val == head.val) next = next.next;
            return deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }

        return head;
    }
}
