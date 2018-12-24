package com.leetcode.string;

import java.util.Stack;

public class No227BasicCalculatorII {
    int i = 0;

    public int calculate(String s) {
        final Stack<Integer> stack = new Stack<>();
        stack.push(nextNum(s));

        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '+') stack.push(nextNum(s));
            else if (c == '-') stack.push(-nextNum(s));
            else if (c == '*') stack.push(stack.pop() * nextNum(s));
            else if (c == '/') stack.push(stack.pop() / nextNum(s));
        }

        int expression = 0;
        while (!stack.isEmpty()) expression += stack.pop();
        return expression;
    }

    public int calculate2(String s) {
        int last = nextNum(s), expression = last;

        while (i < s.length()) {
            char c = s.charAt(i++);
            int num = nextNum(s);
            if (c == '+') expression += (last = num);
            else if (c == '-') expression += (last = -num);
            else if (c == '*') expression += -last + (last = last * num);
            else if (c == '/') expression += -last + (last = last / num);
        }

        return expression;
    }

    private int nextNum(String s) {
        int num = 0;

        while (i < s.length() && s.charAt(i) == ' ') i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) num = num * 10 + (s.charAt(i++) - '0');
        while (i < s.length() && s.charAt(i) == ' ') i++;

        return num;
    }
}
