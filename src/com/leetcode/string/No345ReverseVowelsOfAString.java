package com.leetcode.string;

public class No345ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        final char[] chars = s.toCharArray();
        int lo = 0, hi = chars.length - 1;

        while (lo < hi) {
            while (lo < hi && !isVowel(chars[lo])) lo++;
            while (lo < hi && !isVowel(chars[hi])) hi--;

            if (lo < hi) {
                char tmp = chars[lo];
                chars[lo++] = chars[hi];
                chars[hi--] = tmp;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
