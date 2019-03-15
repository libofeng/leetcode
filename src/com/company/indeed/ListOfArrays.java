package com.company.indeed;

public class ListOfArrays {
    static final int ARRAY_SIZE = 64;

    class ListNode {
        int len = 0;
        char[] array = new char[ARRAY_SIZE];
        ListNode next;
    }

    private ListNode head;
    private int totalLen;

    public ListOfArrays() {
    }

    public ListOfArrays(ListNode head, int totalLen) {
        this.head = head;
        this.totalLen = totalLen;
    }

    public char get(int index) {
        if (index < 0 || index > totalLen) return 0;

        ListNode current = head;
        while (current != null) {
            if (index >= current.len) {
                index -= current.len;
                current = current.next;
            } else return current.array[index];
        }
        return 0;
    }

    public void insert(char c, int index) {
        if (index < 0 || index > totalLen) return;

        ListNode current = head;
        while (current != null) {
            if (index >= current.len) {
                index -= current.len;
                if (index == 0 && current.len < ARRAY_SIZE) {
                    index = current.len;
                    break;
                }
            } else break;

            current = current.next;
        }

        if (current == null) {
            ListNode next = new ListNode();
            if (head == null) head = next;
            else {
                ListNode tail = head;
                while (tail.next != null) tail = tail.next;
                tail.next = next;
            }

            current = next;
        }

        if (current.len == ARRAY_SIZE) {
            ListNode next;
            if (current.next == null || current.next.len == ARRAY_SIZE) {
                next = new ListNode();
                next.next = current.next;
                current.next = next;
            } else next = current.next;

            for (int i = next.len; i > 0; i--) next.array[i] = next.array[i - 1];
            next.len++;
            next.array[0] = current.array[current.len - 1];
            current.len--;
        }

        for (int i = current.len; i > index; i--) current.array[i] = current.array[i - 1];
        current.array[index] = c;
        current.len++;
    }

    public void delete(int index) {
        if (index < 0 || index >= totalLen) return;

        ListNode pre = null, current = head;
        while (index >= current.len) {
            index -= current.len;
            pre = current;
            current = current.next;
        }

        if (pre != null && pre.len + current.len - 1 <= ARRAY_SIZE) {
            for (int i = 0; i < current.len; i++) {
                if (i == index) continue;
                pre.array[pre.len++] = current.array[i];
            }
            current.len = 1;
        }

        current.len--;
        totalLen--;

        if (current.len == 0) {
            if (pre == null) head = current.next;
            else pre.next = current.next;
        } else {
            for (int i = index; i < current.len; i++) current.array[i] = current.array[i + 1];
        }
    }
}
