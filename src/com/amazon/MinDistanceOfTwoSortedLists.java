package com.amazon;

public class MinDistanceOfTwoSortedLists {
    private int findMinDistance(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return 0;
        if (l1 == null || l2 == null) return Math.abs(l1 == null ? l2.val : l1.val);

        int minDistance = Integer.MAX_VALUE;
        while (l1 != null && l2 != null) {
            int d = Math.abs(l1.val - l2.val);
            if (d == 0) return d;

            minDistance = Math.min(minDistance, d);
            if (l1.val < l2.val) l1 = l1.next;
            else l2 = l2.next;

        }

        return minDistance;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3), p1 = l1;
        p1.next = new ListNode(9);
        p1 = p1.next;
        p1.next = new ListNode(20);
        p1 = p1.next;
        p1.next = new ListNode(27);

        ListNode l2 = new ListNode(1), p2 = l2;
        p2.next = new ListNode(10);
        p2 = p2.next;
        p2.next = new ListNode(30);
        p2 = p2.next;
        p2.next = new ListNode(40);

        MinDistanceOfTwoSortedLists solution = new MinDistanceOfTwoSortedLists();
        int minDistance = solution.findMinDistance(l1, l2);

        System.out.println("minDistance = " + minDistance);
    }
}
