package com.lintcode.list;

import java.util.List;
import java.util.PriorityQueue;

public class No104MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;

        ListNode current = lists.get(0);
        for (int i = 1; i < lists.size(); i++) current = merge(current, lists.get(i));

        return current;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            node.next = null;
            p.next = node;
            p = p.next;
        }

        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;

        return dummyHead.next;
    }


    public ListNode mergeKLists2(List<ListNode> lists) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode dummyHead = new ListNode(0), p = dummyHead;

        for (ListNode n : lists) if (n != null) pq.offer(n);

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.offer(node.next);

            node.next = null;
            p.next = node;
            p = p.next;
        }

        ListNode head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }
}
