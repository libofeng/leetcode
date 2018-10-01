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

        ListNode tail = head.next;
        head.next = null;
        ListNode newHead = reverseList(tail);
        tail.next = head;

        return newHead;
    }
}
