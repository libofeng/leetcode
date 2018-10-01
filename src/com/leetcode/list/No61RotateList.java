package com.leetcode.list;

public class No61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k % len;
        if (k == 0) return head;

        ListNode parent = head;
        for (int i = 1; i < (len - k); i++) parent = parent.next;

        tail.next = head;
        head = parent.next;
        parent.next = null;

        return head;
    }
}
