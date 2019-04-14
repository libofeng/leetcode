package com.company.indeed;

public class UnrollLinkedList {
    class Node {
        char[] chars = new char[5];
        Node next;
        int len;
    }

    Node head;
    int totalLen;

    public UnrollLinkedList(Node head, int totalLen) {
        this.head = head;
        this.totalLen = totalLen;
    }

    public char get(int index) {
        if (index < 0 || index >= totalLen)
            return ' ';

        Node cur = head;
        while (cur != null) {
            if (index >= cur.len)
                index -= cur.len;
            else {
                return cur.chars[index];
            }
            cur = cur.next;
        }
        return ' ';
    }

    public void insert(int index, char c) {
        if (index < 0 || index > totalLen)
            return;

        Node prev = new Node();
        prev.next = head;
        Node cur = head;
        while (cur != null) {
            if (index >= cur.len) {
                index -= cur.len;
            } else {
                // node is full
                if (cur.len == 5) {
                    Node newNode = new Node();
                    newNode.chars[0] = cur.chars[4];
                    newNode.len = 1;
                    newNode.next = cur.next;
                    cur.next = newNode;
                    cur.len--;
                }

                // normal case
                cur.len++;
                for (int i = cur.len - 1; i > index; i--)
                    cur.chars[i] = cur.chars[i-1];
                cur.chars[index] = c;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        // node is null
        if (cur == null) {
            Node newNode = new Node();
            newNode.chars[0] = c;
            newNode.len = 1;
            prev.next = newNode;
            // case 4: insert 1st element
            if (head == null)
                head = prev.next;
        }
        totalLen++;
    }

    public void delete(int index) {
        if (index < 0 || index >= totalLen)
            return;

        Node prev = new Node();
        prev.next = head;
        Node cur = head;
        while (cur != null) {
            if (index >= cur.len) {
                index -= cur.len;
            } else {
                if (cur.len == 1) {
                    prev.next = cur.next;
                } else {
                    for (int i = index; i < cur.len - 1; i++) {
                        cur.chars[i] = cur.chars[i+1];
                    }
                    cur.len--;
                }
                break; // DO NOT forget this
            }
            prev = cur;
            cur = cur.next;
        }
        // corner case: only one element in the linked list
        head = prev.next;
        totalLen--;
    }

}

