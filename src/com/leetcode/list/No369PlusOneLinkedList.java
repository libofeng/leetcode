package com.leetcode.list;

public class No369PlusOneLinkedList {
    private int carry;

    public ListNode plusOne(ListNode head) {
        carry = 1;

        plus(head);
        if (carry == 0) return head;

        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }

    private void plus(ListNode head) {
        if (head == null) return;
        plus(head.next);
        if (carry == 0) return;

        carry = ++head.val / 10;
        head.val %= 10;
    }
}
