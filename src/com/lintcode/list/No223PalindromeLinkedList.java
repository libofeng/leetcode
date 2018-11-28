package com.lintcode.list;

public class No223PalindromeLinkedList {
    /**
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        leftP = head;
        return compare(right);
    }

    private ListNode leftP = null;

    private boolean compare(ListNode node) {
        if (node == null) return true;
        if (!compare(node.next)) return false;

        if (node.val == leftP.val) {
            leftP = leftP.next;
            return true;
        } else return false;
    }
}
