package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No500KeyboardRow {
    public String[] findWords(String[] words) {
        final int[] map = new int[128];
        initMap(map);

        final List<String> list = new ArrayList<>();
        for (String w : words) {
            String s = w.toLowerCase();
            int i = 1;
            for (; i < s.length(); i++) {
                if (map[s.charAt(i - 1)] != map[s.charAt(i)]) break;
            }

            if (i == s.length()) list.add(w);
        }

        return list.toArray(new String[list.size()]);
    }

    private void initMap(int[] map) {
        map['a'] = map['s'] = map['d'] = map['f'] = map['g'] = map['h'] = map['j'] = map['k'] = map['l'] = 1;
        map['z'] = map['x'] = map['c'] = map['v'] = map['b'] = map['n'] = map['m'] = 2;
    }
}
