package com.leetcode.math;

public class No722BasicCalculatorIII {
    private int p = 0;

    public int calculate(String s) {
        s = removeSpace(s);
        return cal(s);
    }

    private int cal(String s) {
        int last = 0, result = 0;
        char sign = '+';

        while (p < s.length()) {
            int num;
            if (Character.isDigit(s.charAt(p))) num = nextNum(s);
            else if (s.charAt(p) == '(') {
                p++;
                num = cal(s);
            } else {
                sign = s.charAt(p++);
                continue;
            }

            switch (sign) {
                case '+':
                    result += num;
                    last = num;
                    break;
                case '-':
                    result -= num;
                    last = -num;
                    break;
                case '*':
                    result -= last;
                    last = last * num;
                    result += last;
                    break;
                case '/':
                    result -= last;
                    last = last / num;
                    result += last;
                    break;
                default:

            }

            if (p < s.length() && s.charAt(p) == ')') {
                p++;
                return result;
            }
        }

        return result;
    }

    private String removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != ' ') sb.append(s.charAt(i));
        return sb.toString();
    }

    private int nextNum(String s) {
        int num = 0;
        while (p < s.length() && Character.isDigit(s.charAt(p))) num = num * 10 + (s.charAt(p++) - '0');

        return num;
    }
}
