package com.leetcode.stack;


public class No224BasicCalculator2 {
    private int i = 0;

    public int calculate(String s) {
        int sign = 1, num = 0, result = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '(') result += sign * calculate(s);
            else if (c == ')') break;
            else if (c == '-' || c == '+') {
                result += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        result += sign * num;

        return result;
    }
}
