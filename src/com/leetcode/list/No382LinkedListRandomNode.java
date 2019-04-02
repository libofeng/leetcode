package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class No382LinkedListRandomNode {
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    private List<ListNode> list = new ArrayList<>();
    private Random rnd = new Random();

    public No382LinkedListRandomNode(ListNode head) {
        while (head != null) {
            list.add(head);
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
