package com.leetcode.list;

public class No83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        helper(dummy, head);
        return dummy.next;
    }

    private void helper(ListNode prev, ListNode head) {
        if (head == null) return;

        if (prev.val == head.val) {
            prev.next = head.next;
            helper(prev, prev.next);
        } else {
            helper(head, head.next);
        }

    }
}
