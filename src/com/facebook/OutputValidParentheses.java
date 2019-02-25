package com.facebook;

import java.util.LinkedList;
import java.util.Stack;

public class OutputValidParentheses {
    public String outputValidParentheses(String s) {
        final Stack<Character> stack = new Stack<>();
        final LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    list.addFirst(stack.pop());
                    list.addLast(c);
                }
            } else list.addLast(c);
        }

        final StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        OutputValidParentheses solution = new OutputValidParentheses();
        String valid = solution.outputValidParentheses("((((a)b)()");
        System.out.println("valid = " + valid);
    }
}
