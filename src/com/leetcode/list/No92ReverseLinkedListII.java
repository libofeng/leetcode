package com.leetcode.list;

public class No92ReverseLinkedListII {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0), current = head;
        while(current!=null){
            ListNode node = current;
            current = current.next;

            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }
}
