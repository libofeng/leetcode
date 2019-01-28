package com.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class No791CustomSortString {

    public String customSortString(String S, String T) {
        final Map<Character, Integer> positions = new HashMap<>();
        for (int i = 0; i < S.length(); i++) positions.put(S.charAt(i), i);

        Character[] tchars = new Character[T.length()];
        for (int i = 0; i < tchars.length; i++) tchars[i] = T.charAt(i);
        final Comparator<Character> comparator = new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return positions.getOrDefault(a,128) - positions.getOrDefault(b,128);
            }
        };
        Arrays.sort(tchars, comparator);
        StringBuilder sb = new StringBuilder();
        for (char c : tchars) sb.append(c);

        return sb.toString();
    }
}
