package com.leetcode.list;

public class No82RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
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
}
