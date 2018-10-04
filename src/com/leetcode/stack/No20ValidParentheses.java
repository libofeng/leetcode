package com.leetcode.stack;

import java.util.Stack;

public class No20ValidParentheses {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
