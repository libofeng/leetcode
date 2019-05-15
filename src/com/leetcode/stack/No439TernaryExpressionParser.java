package com.leetcode.stack;

import java.util.Stack;

public class No439TernaryExpressionParser {

    private int p = 0;

    public String parseTernary(String expression) {
        return String.valueOf(parse(expression));
    }

    private char parse(String s) {
        char first = s.charAt(p);

        p += 2;
        char second = s.charAt(p);
        if (p + 1 < s.length() && s.charAt(p + 1) == '?') second = parse(s);

        p += 2;
        char third = s.charAt(p);
        if (p + 1 < s.length() && s.charAt(p + 1) == '?') third = parse(s);

        return first == 'T' ? second : third;
    }


    public String parseTernary2(String expression) {
        final Stack<Character> stack = new Stack<>();
        final int n = expression.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();

                stack.pop();
                char second = stack.pop();

                stack.push(c == 'T' ? first : second);
            } else stack.push(c);
        }

        return stack.pop().toString();
    }

    public String parseTernary3(String expression) {
        while (expression.length() != 1) {
            int i = expression.lastIndexOf("?");    // get the last shown '?'
            char c = expression.charAt(i - 1) == 'T' ? expression.charAt(i + 1) : expression.charAt(i + 3);
            expression = expression.substring(0, i - 1) + c + expression.substring(i + 4);
        }
        return expression;
    }
}
