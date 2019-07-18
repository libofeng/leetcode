package com.company.airbnb;


public class DesignQueueWithLimitedSizeOfArray {
    private final int blockSize;
    private int count;

    private ListNode head, tail;

    public DesignQueueWithLimitedSizeOfArray(int blockSize) {
        this.blockSize = blockSize;
    }

    public static void main(String[] args) {
        DesignQueueWithLimitedSizeOfArray queue = new DesignQueueWithLimitedSizeOfArray(5);
        queue.offer(1);
        queue.offer(2);
        int res = queue.poll();
        assert (1 == res);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        res = queue.poll();
        assert (2 == res);
        res = queue.poll();
        assert (3 == res);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.offer(10);
        res = queue.poll();
        assert (res == 10);
        queue.offer(11);
        res = queue.poll();
        assert (res == 11);
    }

    public void offer(int val) {
        if (tail == null) tail = head = new ListNode(new int[blockSize]);
        if (tail.tailIndex == tail.data.length) {
            tail.next = new ListNode(new int[blockSize]);
            tail = tail.next;
        }

        tail.data[tail.tailIndex++] = val;
        count++;
    }

    public int size() {
        return count;
    }

    public Integer poll() {
        if (size() == 0) return null;

        int val = head.data[head.headIndex++];
        if (head.headIndex == head.data.length) head = head.next;
        if(--count == 0) head = tail = null;

        return val;
    }

    class ListNode {
        ListNode next;
        int[] data;
        int tailIndex, headIndex;

        ListNode(int[] data) {
            this.data = data;
        }
    }
}
