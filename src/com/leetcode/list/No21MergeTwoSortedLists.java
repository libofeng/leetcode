package com.leetcode.list;

public class No21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l2 == null ? l1 : l2;

        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = mergeTwoLists(head.next, head == l1 ? l2 : l1);
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            p.next = node;
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}
