package com.leetcode.queue;

public class MyCircularQueue {
    private int[] q;
    private int h = 0, t = 0, len = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        len = k + 1;
        q = new int[len];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[t] = value;

        t = (t + 1) % len;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;

        h = (h + 1) % len;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        return q[h];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        return q[(t - 1 + len) % len];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return t == h;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (t - h + len) % len == len - 1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
