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
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
