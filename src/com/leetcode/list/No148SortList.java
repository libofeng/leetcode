package com.leetcode.list;

public class No148SortList {
    // divide and conquer, merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head, list2 = slow.next;
        slow.next = null;

        return merge(sortList(list1), sortList(list2));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), p = dummy;

        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val < list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }

            node.next = null;
            p.next = node;
            p = p.next;
        }

        if (list1 == null) p.next = list2;
        if (list2 == null) p.next = list1;

        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }

    // -----------------------------------------------

    // insert sort
    public ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            insert(dummy, node);
        }

        head = dummy.next;
        dummy.next = head;
        return head;
    }

    private void insert(ListNode dummy, ListNode node) {
        ListNode p = dummy;
        while (p.next != null && p.next.val < node.val) p = p.next;

        node.next = p.next;
        p.next = node;
    }
}
