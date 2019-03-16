package com.leetcode.stack;

import java.util.Stack;

public class No155MinStackOneStack {


    /**
     * initialize your data structure here.
     */
    private Stack<Long> stack;
    private long min;

    public No155MinStackOneStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        long d = x - min;
        min = stack.isEmpty() ? x : Math.min(min, x);
        stack.push(stack.isEmpty() ? 0 : d);
    }

    public void pop() {
        long d = stack.pop();
        if (d < 0) min -= d;
    }

    public int top() {
        long d = stack.peek();
        return (int) (d > 0 ? (min + d) : min);
    }

    public int getMin() {
        return (int) min;
    }

}
