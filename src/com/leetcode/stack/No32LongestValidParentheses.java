package com.leetcode.stack;

import java.util.Stack;

public class No32LongestValidParentheses {
    public int longestValidParentheses2(String s) {
        final Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public int longestValidParentheses3(String s) {
        int maxLen = 0, depth = 0, start = -1, len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') depth++;
            else {
                depth--;
                if (depth < 0) {
                    start = i;
                    depth = 0;
                } else if (depth == 0) {
                    maxLen = Math.max(maxLen, i - start);
                }
            }
        }

        start = len;
        depth = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') depth++;
            else {
                depth--;
                if (depth < 0) {
                    depth = 0;
                    start = i;
                } else if (depth == 0) {
                    maxLen = Math.max(maxLen, start - i);
                }
            }
        }

        return maxLen;
    }
}
