package com.leetcode.string;

public class No6ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] builders = new StringBuilder[numRows];
        final int len = s.length();
        for (int i = 0; i < numRows; i++) builders[i] = new StringBuilder();

        int row = 0;
        for (int i = 0; i < s.length(); ) {
            for (int k = 0; k < numRows && i < len; k++) builders[row++].append(s.charAt(i++));
            row -= 2;
            for (int k = 0; k < numRows - 2 && i < len; k++) builders[row--].append(s.charAt(i++));
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder builder : builders) sb.append(builder);
        return sb.toString();
    }
}
