package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != s.length()) return false;
        Map<Character, Character> ab = new HashMap<>(), ba = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (ab.containsKey(a)) {
                if (b != ab.get(a)) return false;
            } else {
                ab.put(a, b);
            }

            if (ba.containsKey(b)) {
                if (a != ba.get(b)) return false;
            } else {
                ba.put(b, a);
            }
        }

        return true;
    }
}
