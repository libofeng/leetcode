package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class No225ImplementStackUsingQueues2 {

    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> q = new LinkedList<>();

    public No225ImplementStackUsingQueues2() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()) return -1;
        int size = q.size();
        for (int i = 1; i < size; i++) q.offer(q.poll());

        return q.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()) return -1;

        int top = pop();
        q.offer(top);
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */