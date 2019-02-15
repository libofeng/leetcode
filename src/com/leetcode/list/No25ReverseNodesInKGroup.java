package com.leetcode.list;

public class No25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0), p = dummyHead, h = head;

        ListNode sublistHead = h, sublistTail = findSublistOfK(h, k);
        while (sublistTail != null) {
            h = sublistTail.next;
            sublistTail.next = null;

            p.next = reverse(sublistHead);
            p = sublistHead;

            sublistHead = h;
            sublistTail = findSublistOfK(h, k);
        }
        p.next = sublistHead;

        head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }

    // return tail
    private ListNode findSublistOfK(ListNode head, int k) {
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (p == null) return null;
            p = p.next;
        }
        return p;
    }

    // return head
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next, newHead = reverse(next);
        head.next = null;
        next.next = head;

        return newHead;
    }
}
