package com.leetcode.list;

import java.util.Stack;

public class No445AddTwoNumbersII {
    // reverse the list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode current = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n = carry;
            if (l1 != null) {
                n += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }
            carry = n / 10;

            ListNode node = new ListNode(n % 10);
            node.next = current;
            current = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = current;
            current = node;
        }

        return current;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode node = head;
            head = head.next;

            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    // using Stack
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        final Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode current = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + carry;
            carry = n / 10;

            ListNode node = new ListNode(n % 10);
            node.next = current;
            current = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = current;
            current = node;
        }

        return current;
    }
}
