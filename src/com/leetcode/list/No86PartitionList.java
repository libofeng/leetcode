package com.leetcode.list;

public class No86PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0), dummyR = new ListNode(0), tailL = dummyL, tailR = dummyR;

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            if (node.val < x) {
                tailL.next = node;
                tailL = node;
            } else {
                tailR.next = node;
                tailR = node;
            }
        }
        tailL.next = dummyR.next;
        dummyR.next = null;

        return dummyL.next;
    }
}
