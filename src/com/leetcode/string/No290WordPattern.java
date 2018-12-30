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
            char p = pattern.charAt(i);
            String w = words[i];
            if (ab.containsKey(p)) if (!ab.get(p).equals(w)) return false;
            if (ba.containsKey(w)) if (ba.get(w) != p) return false;

            ab.put(p, w);
        }

        return true;
    }
}
