package com.leetcode.contest.contest150;

public class No5048FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        final int[] count = new int[26];
        for (char c : chars.toCharArray()) count[c - 'a']++;

        int total = 0;
        for (String w : words) {
            final int[] counter = count.clone();
            int i = 0;
            for (; i < w.length(); i++) if (counter[w.charAt(i) - 'a']-- == 0) break;

            if (i == w.length()) total += w.length();
        }

        return total;
    }
}
