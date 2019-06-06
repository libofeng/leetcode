package com.leetcode.queue;

public class No641DesignCircularDeque {

    private final int k, len;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    private int[] nums;
    private int head, tail;

    public No641DesignCircularDeque(int k) {
        this.k = k;
        this.len = k + 1;
        nums = new int[len];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        nums[head] = value;
        head = (++head + len) % len;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        tail = (--tail + len) % len;
        nums[tail] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        head = (--head + len) % len;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        tail = (++tail + len) % len;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return nums[(head - 1 + len) % len];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return nums[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (head - tail + len) % len == k;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
