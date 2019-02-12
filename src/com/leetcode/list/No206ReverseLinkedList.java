package com.leetcode.list;

public class No206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0), current = head;
        while (current != null) {
            ListNode node = current;
            current = current.next;

            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null) {
            ListNode node = head;
            head = head.next;

            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head.next, newHead = reverseList3(head.next);
        head.next = null;
        tail.next = head;

        return newHead;
    }


    private ListNode tail;

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList4(head.next);

        if (tail == null) tail = newHead;

        tail.next = head;
        tail = head;
        tail.next = null;

        return newHead;
    }
}
