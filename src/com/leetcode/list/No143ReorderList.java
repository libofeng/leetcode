package com.leetcode.list;

import java.util.Deque;
import java.util.LinkedList;

public class No143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;

        // find the middle point, seperate to two lists
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second
        ListNode secondHead = slow.next;
        if (fast.next != null) fast = fast.next;
        slow.next = null;
        reverse(secondHead);
        secondHead = fast;
        // combine together
        while (secondHead != null) {
            ListNode nextHead = head.next;
            ListNode nextSecondHead = secondHead.next;
            head.next = secondHead;
            secondHead.next = nextHead;
            head = nextHead;
            secondHead = nextSecondHead;
        }

    }

    private ListNode reverse(ListNode root) {
        if (root.next == null) return root;
        ListNode next = reverse(root.next);
        next.next = root;
        root.next = null;
        return root;
    }


    public void reorderList2(ListNode head) {
        final Deque<ListNode> dq = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            dq.offer(p);
            p = p.next;
        }

        ListNode dummyHead = new ListNode(0), prev = dummyHead;
        while (dq.size() > 1) {
            prev.next = dq.pollFirst();
            prev = prev.next;
            prev.next = dq.pollLast();
            prev = prev.next;
        }

        if (!dq.isEmpty()) {
            prev.next = dq.pollLast();
            prev = prev.next;
        }

        // clear the next pointer otherwise there is a circle.
        prev.next = null;
    }
}
