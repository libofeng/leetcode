package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No291WordPatternII {
    private Map<Character, String> mapAB = new HashMap<>();
    private Map<String, Character> mapBA = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, str, 0, 0);
    }

    private boolean dfs(String p, String s, int i, int start) {
        if (i == p.length()) return start == s.length();
        if (start == s.length()) return false;

        char c = p.charAt(i);
        if (mapAB.containsKey(c)) {
            String mapping = mapAB.get(c);
            if (s.substring(start).startsWith(mapping)) return dfs(p, s, i + 1, start + mapping.length());
            return false;
        }

        for (int k = start; k < s.length(); k++) {
            String mapping = s.substring(start, k + 1);
            if (mapBA.containsKey(mapping) && mapBA.get(mapping) != c) continue;

            mapAB.put(c, mapping);
            mapBA.put(mapping, c);
            if (dfs(p, s, i + 1, k + 1)) return true;
            mapAB.remove(c);
            mapBA.remove(mapping);
        }

        return false;
    }
}
