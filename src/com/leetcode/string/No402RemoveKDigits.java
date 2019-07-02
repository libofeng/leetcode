package com.leetcode.string;

import java.util.Stack;

public class No402RemoveKDigits {
    // Time: O(N), Space: O(N)
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k-- > 0) stack.pop();
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        int index = sb.length() - 1;
        while (index > 0 && sb.charAt(index) == '0') sb.setLength(index--);

        return sb.reverse().toString();
    }
}
