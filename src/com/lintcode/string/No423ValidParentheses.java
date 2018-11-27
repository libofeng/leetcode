package com.lintcode.string;

import java.util.Stack;

public class No423ValidParentheses {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        final Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) return true;

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) return false;
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) return false;
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) return false;
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
