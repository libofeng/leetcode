package com.leetcode.contest.contest143;

public class No1106ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) return "t".equals(expression);

        char op = expression.charAt(0);
        expression = expression.substring(2, expression.length() - 1);
        if (op == '!') return !parseBoolExpr(expression);

        boolean result = op == '&';

        int p = 0;
        while (p < expression.length()) {
            char c = expression.charAt(p);
            int next = p;
            String sub = "" + c;

            if (c == '!' || c == '|' || c == '&') {
                next = findNext(expression, p);
                sub = expression.substring(p, next + 1);
            }

            if (op == '&') {
                if (!parseBoolExpr(sub)) return false;
            } else {
                if (parseBoolExpr(sub)) return true;
            }
            p = next + 2;
        }

        return result;
    }

    private int findNext(String expression, int i) {
        int left = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (c == '(') left++;
            else if (c == ')' && --left == 0) return i;

            i++;
        }

        return i;
    }
}
