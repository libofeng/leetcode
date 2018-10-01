package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class No142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
