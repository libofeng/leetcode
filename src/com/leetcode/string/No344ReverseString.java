package com.leetcode.string;

public class No344ReverseString {
    public String reverseString(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0, j = s.length() - 1; j >= 0; i++, j--) chars[j] = s.charAt(i);

        return new String(chars);
    }
}
