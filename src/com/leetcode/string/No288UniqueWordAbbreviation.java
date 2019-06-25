package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No288UniqueWordAbbreviation {
    private Map<String, String> map = new HashMap<>();

    public No288UniqueWordAbbreviation(String[] dictionary) {
        for (String w : dictionary) {
            String abbr = abbr(w);
            if (!map.containsKey(abbr)) map.put(abbr, w);
            else if (!w.equals(map.get(abbr))) map.put(abbr, "");
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbr(word);
        return !map.containsKey(abbr) || word.equals(map.get(abbr));
    }

    private String abbr(String w) {
        int len = w.length();
        if (len <= 2) return w;
        else return w.charAt(0) + "" + (len - 2) + w.charAt(len - 1);
    }
}
