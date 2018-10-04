package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        final Map<Character, String> ab = new HashMap<>();
        final Map<String, Character> ba = new HashMap<>();
        final String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            if (ab.containsKey(c)) {
                if (!words[i].equals(ab.get(c))) return false;
            } else {
                ab.put(c, words[i]);
            }

            if (ba.containsKey(words[i])) {
                if (!ba.get(words[i]).equals(c)) return false;
            } else {
                ba.put(words[i], c);
            }
        }

        return true;
    }
}
