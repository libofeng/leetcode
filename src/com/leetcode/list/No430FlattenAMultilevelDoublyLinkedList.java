package com.leetcode.list;

public class No430FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        flattenList(head);
        return head;
    }

    private Node flattenList(Node head) {
        Node tail = head;
        while (tail != null) {
            if (tail.child != null) {
                Node next = tail.next;

                tail.next = tail.child;
                tail.child.prev = tail;
                tail.child = null;

                tail = flattenList(tail.next);
                tail.next = next;
                if (next != null) next.prev = tail;
            }

            if (tail.next == null) break;
            else tail = tail.next;
        }

        return tail;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
