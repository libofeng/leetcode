package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class No225ImplementStackUsingQueues {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public No225ImplementStackUsingQueues() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        final Queue<Integer> tmp = new LinkedList<>();

        tmp.offer(x);
        while (!q.isEmpty()) tmp.offer(q.poll());
        q = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
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