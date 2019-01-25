package com.leetcode.string;

import java.util.Arrays;

public class No242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) if (count[i] != 0) return false;

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        Arrays.sort(schars);

        char[] tchars = t.toCharArray();
        Arrays.sort(tchars);

        return Arrays.equals(schars, tchars);
    }
}
