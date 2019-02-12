package com.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23MergeKSortedLists {
    // O(K^2 * N)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) list = merge(list, lists[i]);

        return list;
    }

    // Time: O(N), Space: O(N)
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = merge(head.next, head == l1 ? l2 : l1);

        return head;
    }


    // -------------------------
    // O(LogK * K * N), Space: O(K)
    public ListNode mergeKLists2(ListNode[] lists) {
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

    // ------------------------- Divide and Conquer
    // Time: O(LogK * K * N), Space: O(K * (N + LogK)) OR O(K * LogK)
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int k = lists.length, k1 = k / 2, k2 = k - k1;
        ListNode[] lists1 = new ListNode[k1], lists2 = new ListNode[k2];
        System.arraycopy(lists, 0, lists1, 0, k1);
        System.arraycopy(lists, k1, lists2, 0, k2);

        // Time:O(KN), Space: O(KN), it can be O(1) if we change it to iteration
        return merge(mergeKLists3(lists1), mergeKLists3(lists2));
    }
}
