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

    public int romanToInt2(String s) {
        int num = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            int n = map(s.charAt(i));
            num += i < len - 1 && n < map(s.charAt(i + 1)) ? -n : n;
        }

        return num;
    }

    private int map(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
