package com.leetcode.string;

public class No186ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);

        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "the sky is blue", t = "blue is sky the";

        No186ReverseWordsInAStringII solution = new No186ReverseWordsInAStringII();
        char[] chars = s.toCharArray();
        solution.reverseWords(chars);
        String reverse = new String(chars);
        System.out.println("t.equals(reverse) = " + t.equals(reverse));
    }
}
