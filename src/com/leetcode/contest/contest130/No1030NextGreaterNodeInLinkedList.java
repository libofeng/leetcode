package com.leetcode.contest.contest130;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No1030NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        final Stack<ListNode> stack = new Stack<>();
        final Map<ListNode, Integer> map = new HashMap<>();

        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            while (!stack.isEmpty() && stack.peek().val < p.val) map.put(stack.pop(), p.val);
            stack.push(p);
            p = p.next;
        }

        final int[] result = new int[n];
        int index = 0;

        p = head;
        while (p != null) {
            result[index++] = map.getOrDefault(p, 0);
            p = p.next;
        }

        return result;
    }
}
