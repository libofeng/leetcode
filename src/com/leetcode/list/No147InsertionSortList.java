package com.leetcode.list;

public class No147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = head;

        while (p != null) {
            ListNode node = p;
            p = p.next;
            node.next = null;

            insert(dummyHead, node); // can be optimized without using the method call
        }

        return dummyHead.next;
    }

    private void insert(ListNode head, ListNode node) {
        ListNode p = head;
        while (p.next != null && p.next.val <= node.val) p = p.next;

        node.next = p.next;
        p.next = node;
    }
}
