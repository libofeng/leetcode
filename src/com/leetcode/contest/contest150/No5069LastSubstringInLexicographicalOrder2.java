package com.leetcode.contest.contest150;

public class No5069LastSubstringInLexicographicalOrder2 {

    // Time: O(N^2)
    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        char maxChar = maxChar(chars);

        int maxIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == maxChar && isLarger(chars, i, maxIndex)) maxIndex = i;
        }

        return s.substring(maxIndex);
    }

    // O(N)
    private boolean isLarger(char[] chars, int cur, int maxIndex) {
        for (int i = cur; i < chars.length; i++) {
            if (chars[i] == chars[maxIndex + i - cur]) continue;
            return chars[i] >= chars[maxIndex + i - cur];
        }

        return false;
    }

    // O(N)
    private char maxChar(char[] chars) {
        char maxChar = 'a';
        for (char c : chars) maxChar = (char) Math.max(maxChar, c);
        return maxChar;
    }

}
