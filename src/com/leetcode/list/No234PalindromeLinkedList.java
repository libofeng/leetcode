package com.leetcode.list;

import java.util.Stack;

public class No234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow.next, tail = fast.next == null ? fast : fast.next;
        slow.next = null;
        reverse(right);
        right = tail;

        while (right != null && head != null) {
            if (right.val != head.val) return false;
            right = right.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = reverse(head.next);
        next.next = head;
        head.next = null;

        return head;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode right = slow.next, tail = fast.next == null ? fast : fast.next;
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) return false;
            head = head.next;
        }

        return true;
    }
}
