package com.leetcode.math;

import java.util.Stack;

public class No150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            switch (t) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int d = stack.pop();
                    stack.push(stack.pop() / d);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}
