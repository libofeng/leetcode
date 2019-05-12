package com.leetcode.list;

public class No708InsertIntoACyclicSortedList {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next == head && current.val == current.next.val) {
                // all node have the same value
                insertAfter(current, node);
                return head;
            } else if (current.val > current.next.val) {
                // max -> min;
                if (insertVal >= current.val || insertVal <= current.next.val) {
                    insertAfter(current, node);
                    return head;
                }
            } else if (insertVal <= current.next.val && insertVal >= current.val) {
                insertAfter(current, node);
                return head;
            }
            current = current.next;
        }

        return head;
    }

    private void insertAfter(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }
}
