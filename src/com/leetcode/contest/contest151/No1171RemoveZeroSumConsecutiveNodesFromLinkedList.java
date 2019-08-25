package com.leetcode.contest.contest151;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No1171RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        final List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            shrink(list);
            head = head.next;
        }

        System.out.println(list.size());
        if (list.size() == 0) return null;

        head = list.get(0);
        head.next = null;

        ListNode p = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = list.get(i);
            node.next = null;

            p.next = node;
            p = p.next;
        }

        return head;
    }

    private void shrink(List<ListNode> list) {
        int sum = 0, index = list.size();
        for (int i = list.size() - 1; i >= 0; i--) {
            if ((sum -= list.get(i).val) == 0) index = i;
        }
        for (int i = list.size() - 1; i >= index; i--) list.remove(i);
    }

    // https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/366319/JavaC%2B%2BPython-Greedily-Skip-with-HashMap
    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            m.putIfAbsent(prefix, cur);
            cur = m.get(prefix).next = cur.next;
        }
        return dummy.next;
    }

}
