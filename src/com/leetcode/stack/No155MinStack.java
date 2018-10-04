package com.leetcode.stack;

import java.util.Stack;

public class No155MinStack {
    private final Stack<Integer> stack = new Stack<>(), minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.isEmpty() ? x : getMin()));
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
