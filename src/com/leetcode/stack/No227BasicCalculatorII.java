package com.leetcode.stack;

import java.util.Stack;

public class No227BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        char sign = '+';
        Stack<Integer> S = new Stack<>();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }

            if ((!Character.isDigit(c) && ' ' != c) || i == len - 1) {
                switch (sign) {
                    case '-':
                        S.push(-num);
                        break;
                    case '+':
                        S.push(num);
                        break;
                    case '/':
                        S.push(S.pop() / num);
                        break;
                    case '*':
                        S.push(S.pop() * num);
                }

                sign = c;
                num = 0;
            }
        }
        int sum = 0;
        for (Integer n : S) sum += n;

        return sum;
    }

    //------------------------------------


    private int p = 0;

    public int calculate2(String s) {
        s = s.trim();
        int last = nextNum(s), result = last;
        while (p < s.length()) {
            char c = s.charAt(p++);

            switch (c) {
                case '+':
                    last = nextNum(s);
                    result += last;

                    break;
                case '-':
                    last = -nextNum(s);
                    result += last;
                    break;
                case '*':
                    result -= last;
                    last *= nextNum(s);
                    result += last;
                    break;
                case '/':
                    result -= last;
                    last /= nextNum(s);
                    result += last;
                    break;
                default:
            }
        }

        return last;
    }

    private int nextNum(String s) {
        int n = 0;

        while (p < s.length() && s.charAt(p) == ' ') p++;
        while (p < s.length() && Character.isDigit(s.charAt(p))) n = n * 10 + (s.charAt(p++) - '0');
        while (p < s.length() && s.charAt(p) == ' ') p++;

        return n;
    }
}
