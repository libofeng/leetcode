package com.leetcode.list;

public class No21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l2 == null ? l1 : l2;

        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = mergeTwoLists(head.next, head == l1 ? l2 : l1);
        return head;
    }
}
