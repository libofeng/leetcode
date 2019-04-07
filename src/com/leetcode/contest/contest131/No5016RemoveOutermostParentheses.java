package com.leetcode.contest.contest131;

public class No5016RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        final StringBuilder sb = new StringBuilder();

        int start = 0;
        while (start < S.length() - 1) {
            int end = findPrimitive(S, start);
            if (end > start + 1) sb.append(S.substring(start + 1, end));
            start = end + 1;
        }

        return sb.toString();
    }

    private int findPrimitive(String s, int start) {
        int left = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (--left == 0) return i;
        }

        return start;
    }
}
