package com.lintcode.string;

import java.util.HashMap;
import java.util.Map;

public class No419RomanToInteger {
    /**
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int number = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int n = map.get(s.charAt(i));
            number += n < map.get(s.charAt(i + 1)) ? -n : n;
        }
        number += map.get(s.charAt(s.length() - 1));

        return number;
    }
}
