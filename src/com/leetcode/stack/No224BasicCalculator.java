package com.leetcode.stack;

import java.util.Stack;

public class No224BasicCalculator {
    public int calculate(String s) {
        int num = 0, sign = 1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == s.length() - 1) result += num * sign;
            } else {
                result += num * sign;

                if (c == '+') sign = 1;
                else if (c == '-') sign = -1;
                else if (c == '(') {
                    i++;
                    int start = i, count = 1;
                    while (count > 0) {
                        char ch = s.charAt(i++);
                        if (ch == '(') count++;
                        else if (ch == ')') count--;
                    }
                    i--;

                    result += calculate(s.substring(start, i)) * sign;
                }

                num = 0;
            }
        }

        return result;
    }


    public int calculate2(String s) {
        final Stack<Integer> stack = new Stack<>();
        int num = 0, sign = 1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == s.length() - 1) result += num * sign;
            } else {
                result += num * sign;
                num = 0;

                if (c == '+') sign = 1;
                else if (c == '-') sign = -1;
                else if (c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (c == ')') {
                    result = stack.pop() * result + stack.pop();
                }
            }
        }

        return result;
    }

    private int p = 0;

    public int calculate3(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();

        int result = nextNum(s), sign = 1;
        while (p < s.length()) {
            char c = s.charAt(p);
            if (Character.isDigit(c)) result += sign * nextNum(s);
            else {
                p++;

                if (c == '(') {
                    stack.push(result);
                    stack.push(sign);

                    result = 0;
                    sign = 1;
                } else if (c == ')') {
                    sign = stack.pop();
                    result *= sign;
                    result += stack.pop();
                } else if (c == '-') sign = -1;
                else if (c == '+') sign = 1;
            }
        }

        return result;
    }

    private int nextNum(String s) {
        int n = 0;

        while (p < s.length() && s.charAt(p) == ' ') p++;
        while (p < s.length() && Character.isDigit(s.charAt(p))) n = n * 10 + (s.charAt(p++) - '0');
        while (p < s.length() && s.charAt(p) == ' ') p++;

        return n;
    }

    public static void main(String[] args) {
        No224BasicCalculator solution = new No224BasicCalculator();
        int result = solution.calculate3(" 2-1 + 2 ");
        System.out.println("result = " + result);
    }
}
