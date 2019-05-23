package com.leetcode.list;

public class No83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head, current = head.next;
        if (prev.val == current.val) {
            prev.next = current.next;
            current.next = null;
            return deleteDuplicates(head);
        }

        head.next = deleteDuplicates(head.next);
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
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


    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            if (p == dummyHead || node.val != p.val) {
                p.next = node;
                p = p.next;
            }
        }

        return dummyHead.next;
    }
}
