package com.leetcode.list;

import java.util.Random;

public class No382LinkedListRandomNode2 {
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    private Random rnd = new Random();
    private ListNode head;

    public No382LinkedListRandomNode2(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    // https://leetcode.com/problems/linked-list-random-node/discuss/85705/Java-two-solutions-easy-to-understand
    // https://www.youtube.com/watch?v=A1iwzSew5QY
    public int getRandom() {
        ListNode p = head;
        int count = 0;
        int result = -1;
        while (p != null) {
            if (rnd.nextInt(++count) == 0) result = p.val;
            p = p.next;
        }

        return result;
    }
}