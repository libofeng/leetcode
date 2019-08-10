package com.leetcode.contest.biweekly.contest6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No1153StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;

        final Map<Character, Character> map = new HashMap<>();
        final Set<Character> set = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i), b = str2.charAt(i);
            set.add(b);

            if (map.containsKey(a)) {
                if (map.get(a) != b) return false;
            } else map.put(a, b);
        }

        return set.size() < 26;
    }
}
