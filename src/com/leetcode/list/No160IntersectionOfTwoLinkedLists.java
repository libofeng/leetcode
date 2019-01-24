package com.leetcode.list;

public class No160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = len(headA), len2 = len(headB);
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }

        while (len2 > len1) {
            headB = headB.next;
            len2--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int len(ListNode list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }

        return len;
    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }
}
