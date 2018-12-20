package com.leetcode.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class No953VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        Comparator<String> comparator = (a, b) -> {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                int aOrder = map.get(a.charAt(i));
                int bOrder = map.get(b.charAt(i));

                if (aOrder != bOrder) return aOrder - bOrder;
            }

            return a.length() - b.length();
        };


        for (int i = 1; i < words.length; i++) {
            if (comparator.compare(words[i - 1], words[i]) >= 0) return false;
        }

        return true;
    }
}
