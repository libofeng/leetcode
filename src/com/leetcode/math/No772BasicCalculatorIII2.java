package com.leetcode.math;

public class No772BasicCalculatorIII2 {
    public int calculate(String s) {
        int result = 0, last = 0, num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '(') {
                String sub = findSubExpression(s, i);
                i += sub.length() + 1;
                num = calculate(sub);

            } else {
                int[] res = calc(last, num, operator);
                result += res[0];
                last = res[1];
                num = 0;

                operator = c;
            }
        }
        result += calc(last, num, operator)[0];

        return result;
    }

    private int[] calc(int last, int num, char operator) {
        switch (operator) {
            case '+':
                return new int[]{num, num};
            case '-':
                return new int[]{-num, -num};
            case '*':
                return new int[]{-last + last * num, last * num};
            case '/':
                return new int[]{-last + last / num, last / num};
            default:
                return new int[]{0, 0};
        }
    }

    private String findSubExpression(String s, int start) {
        int left = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')' && --left == 0) return s.substring(start + 1, i);
        }

        return "";
    }

    public static void main(String[] args) {
        No772BasicCalculatorIII2 solution = new No772BasicCalculatorIII2();
        int result = solution.calculate("2*(5+5*2)/3+(6/2+8)");
        System.out.println("result = " + result);
    }
}
