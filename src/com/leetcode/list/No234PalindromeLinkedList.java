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
        final Stack<ListNode> stack = new Stack<>();

        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (p == node) return true;
            if (node.val != p.val) return false;

            p = p.next;
        }

        return true;
    }

    // -------------------------------------

    private ListNode forward;

    public boolean isPalindrome3(ListNode head) {
        forward = head;

        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head == null) return true;
        if (!dfs(head.next)) return false;

        if (head.val != forward.val) return false;
        forward = forward.next;
        return true;
    }
}
