package com.leetcode.string;

public class No394DecodeString {
    private int p = 0;

    public String decodeString(String s) {
        int num = 0;
        final StringBuilder sb = new StringBuilder();
        while (p < s.length()) {
            char c = s.charAt(p++);

            if (c == '[') {
                String decoded = decodeString(s);
                for (int i = 0; i < num; i++) sb.append(decoded);
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else sb.append(c);
        }

        return sb.toString();
    }

}
