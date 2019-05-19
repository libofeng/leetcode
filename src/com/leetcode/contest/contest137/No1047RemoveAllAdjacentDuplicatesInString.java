package com.leetcode.contest.contest137;

import java.util.Stack;

public class No1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) return removeDuplicates(S.substring(0, i - 1) + S.substring(i + 1));
        }

        return S;
    }

    public String removeDuplicates2(String S) {
        if (S == null || S.length() < 2) return S;

        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        final StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
