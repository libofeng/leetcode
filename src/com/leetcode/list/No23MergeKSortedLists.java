package com.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) if (list != null) pq.offer(list);

        ListNode dummy = new ListNode(0), p = dummy;
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();

            // optimization
            while (list != null && (pq.isEmpty() || list.val <= pq.peek().val)) {
                ListNode node = list;
                list = list.next;

                node.next = null;
                p.next = node;
                p = p.next;
            }

            if (list != null) pq.offer(list);
        }

        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}
