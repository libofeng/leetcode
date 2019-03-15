package com.company.indeed;

import java.util.Stack;

public class StackWithMinOneStack {
    private static final Stack<Integer> stack = new Stack<>();
    private int min = 0;

    void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = val;
        } else {
            int d = val - min;
            stack.push(d);
            min = Math.min(min, val);
        }
    }

    int pop() {
        int d = stack.pop();
        if (d > 0) min -= d;
        return d > 0 ? (min + d) : min;
    }

    int peek() {
        int d = stack.peek();
        return d > 0 ? (min + d) : min;
    }

    int min() {
        return min;
    }
}
