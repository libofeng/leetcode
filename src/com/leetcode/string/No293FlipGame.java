package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No293FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        final List<String> result = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '+' && chars[i - 1] == '+') {
                chars[i] = '-';
                chars[i - 1] = '-';
                result.add(new String(chars));
                chars[i] = '+';
                chars[i - 1] = '+';
            }
        }

        return result;
    }
}
