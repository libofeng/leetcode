package com.leetcode.string;

public class No557ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int start = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
