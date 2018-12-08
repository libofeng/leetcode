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
}
