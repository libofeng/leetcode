package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        final Map<Character, String> ab = new HashMap<>();
        final Map<String, Character> ba = new HashMap<>();

        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;

        for(int i = 0;i<words.length;i++){
            char a = pattern.charAt(i);
            String b = words[i];

            if(ab.containsKey(a) && !b.equals(ab.get(a))) return false;
            if(ba.containsKey(b) && a != ba.get(b)) return false;

            ab.put(a, b);
            ba.put(b, a);
        }

        return true;
    }
}
