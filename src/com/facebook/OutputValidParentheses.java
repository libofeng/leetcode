package com.facebook;

import java.util.LinkedList;
import java.util.Stack;

public class OutputValidParentheses {
    public String outputValidParentheses(String s) {
        final LinkedList<Integer> validIndex = new LinkedList<>();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) validIndex.addLast(i);
            else if (c == '(') stack.push(i);
            else if (!stack.isEmpty()) {
                validIndex.addFirst(stack.pop());
                validIndex.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : validIndex) sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        OutputValidParentheses solution = new OutputValidParentheses();
        String valid = solution.outputValidParentheses("((((a)b)()");
        System.out.println("valid = " + valid);
    }
}
