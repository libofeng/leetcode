package com.company.indeed;

import java.util.Stack;

public class StackWithMin {

    // similar to No155MinStack
    private static final Stack<Integer> stack = new Stack<>(), min = new Stack<>();

    void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() || val < min.peek() ? val : min.peek());
    }

    int pop() {
        if (stack.isEmpty()) return -1;
        min.pop();
        return stack.pop();
    }

    int peek() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    int min() {
        if (min.isEmpty()) return -1;
        return min.peek();
    }
}
