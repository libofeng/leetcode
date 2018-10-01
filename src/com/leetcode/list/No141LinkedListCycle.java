package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class No141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }

        return false;
    }
}
