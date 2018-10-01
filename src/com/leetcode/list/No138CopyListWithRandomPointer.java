package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class No138CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        return copy(head);
    }

    private RandomListNode copy(RandomListNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        RandomListNode n = new RandomListNode(node.label);
        map.put(node, n);

        n.next = copy(node.next);
        n.random = copy(node.random);

        return n;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        RandomListNode current = head;
        while (current != null) {
            RandomListNode n = new RandomListNode(current.label);
            n.next = current.next;
            n.random = current.random;

            current.next = n;
            current = current.next.next;
        }

        current = head.next;
        while (current != null) {
            if (current.random != null) current.random = current.random.next;
            current = current.next == null ? null : current.next.next;
        }

        RandomListNode dummy = new RandomListNode(0), tail = dummy;
        current = head;
        while (current != null) {
            RandomListNode n = current.next;
            current.next = current.next.next;
            current = current.next;

            n.next = null;
            tail.next = n;
            tail = n;
        }

        return dummy.next;
    }
}
