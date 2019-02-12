package com.leetcode.string;

public class No8StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;

        char first = str.charAt(0);
        int sign = first == '-' ? -1 : 1, start = first == '-' || first == '+' ? 1 : 0;
        long num = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) break;

            num = num * 10 + (c - '0') * sign;
            if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) num;
    }


    public int myAtoi2(String str) {
        int sign = 1;
        long num = 0;
        boolean signFound = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                if (signFound) break;
            } else if (c == '+' || c == '-') {
                if (signFound) break;
                signFound = true;
                if (c == '-') sign = -1;
            } else if (Character.isDigit(c)) {
                signFound = true;

                num = num * 10 + (c - '0') * sign;
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else break;
        }

        return (int) num;
    }
}
