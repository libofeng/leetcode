package com.leetcode.math;

public class No772BasicCalculatorIII3 {
    public static void main(String[] args) {
        No772BasicCalculatorIII3 solution = new No772BasicCalculatorIII3();
        int result = solution.calculate("6-4 / 2");
        System.out.println("result = " + result);
    }

    public int calculate(String s) {
        int result = 0, num = 0, last = 0;
        char op = '+';

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '(') {
                int start = i - 1, end = findEnd(s, start);
                num = calculate(s.substring(start + 1, end));
                i = end + 1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i < s.length() && Character.isDigit(s.charAt(i))) continue;
            } else {
                if (c != ' ') op = c;
                continue;
            }

            switch (op) {
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
                    result += last * num;
                    last = last * num;
                    break;
                case '/':
                    result -= last;
                    result += last / num;
                    last = last / num;
                    break;
                default:
            }
            num = 0;
        }

        return result;
    }

    private int findEnd(String s, int start) {
        int left = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')' && --left == 0) return i;
        }

        return s.length() - 1;
    }
}
