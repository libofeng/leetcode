package com.leetcode.list;

public class No2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int n = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = n / 10;

            current.next = new ListNode(n % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry > 0 ? new ListNode(carry) : null;

        int a = l1 == null ? 0 : l1.val, b = l2 == null ? 0 : l2.val;
        int n = a + b + carry;
        carry = n / 10;
        final ListNode node = new ListNode(n % 10);
        node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);

        return node;
    }
}
