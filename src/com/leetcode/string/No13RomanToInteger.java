package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No13RomanToInteger {
    public int romanToInt(String s) {
        int R = 0;
        final Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        for (int i = 0; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            R += (i < s.length() - 1 && num < map.get(s.charAt(i + 1))) ? -num : num;
        }

        return R;
    }
}
