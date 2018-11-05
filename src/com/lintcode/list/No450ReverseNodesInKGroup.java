package com.lintcode.list;

public class No450ReverseNodesInKGroup {
    /**
     * @param head: a ListNode
     * @param k:    An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;

        int len = findLen(head);
        ListNode dummyHead = new ListNode(0), tail = dummyHead;

        while (head != null && len >= k) {
            ListNode nextTail = head;
            for (int i = 0; i < k; i++) {
                len--;
                ListNode node = head;
                head = head.next;

                node.next = tail.next;
                tail.next = node;
            }
            tail = nextTail;
        }
        tail.next = head;

        return dummyHead.next;
    }

    private int findLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }
}
