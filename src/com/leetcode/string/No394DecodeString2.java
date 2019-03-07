package com.leetcode.string;

public class No394DecodeString2 {
    public String decodeString(String s) {
        int num = 0;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                int closeIndex = findCloseIndex(s, i);
                String decoded = decodeString(s.substring(i + 1, closeIndex));
                i = closeIndex;

                for (int k = 0; k < num; k++) sb.append(decoded);
                num = 0;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else sb.append(c);
        }

        return sb.toString();
    }

    private int findCloseIndex(String s, int start) {
        int left = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') left++;
            else if (c == ']' && --left == 0) return i;
        }

        return start;
    }
}
