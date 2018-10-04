package com.leetcode.stack;

import java.util.Stack;

public class No150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if ("+".equals(t)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(t)) {
                int n = stack.pop();
                stack.push(stack.pop() - n);
            } else if ("*".equals(t)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("/".equals(t)) {
                int n = stack.pop();
                stack.push(stack.pop() / n);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}
