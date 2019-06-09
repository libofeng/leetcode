package com.leetcode.contest.contest140;

public class No5086SmallestSubsequenceOfDistinctCharacters {
    // It's the same problem of No316RemoveDuplicateLetters
    public String smallestSubsequence(String text) {
        if (text.isEmpty()) return "";

        final int[] counter = new int[128];
        for (int i = 0; i < text.length(); i++) counter[text.charAt(i)]++;

        char minChar = 128;
        int minIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < minChar) {
                minChar = c;
                minIndex = i;
            }

            if (--counter[c] == 0) {
                return minChar + smallestSubsequence(text.substring(minIndex + 1).replaceAll("" + minChar, ""));
            }
        }

        return "";
    }
}
