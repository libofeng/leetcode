package com.leetcode.string;

public class No640SolveTheEquation {
    private static final String NO_SOLUTION = "No solution";
    private static final String INFINITE_SOLUTION = "Infinite solutions";

    public String solveEquation(String equation) {
        int x = 0, value = 0, num = 0, flag = 1, sign = 1;

        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (c == '+' || c == '-') {
                value += flag * sign * num;
                num = 0;

                sign = c == '+' ? 1 : -1;
            } else if (c == 'x') {
                if (num == 0 && i > 0 && equation.charAt(i - 1) == '0') num = 0;
                else if (num == 0) num = 1;

                x += flag * sign * num;
                num = 0;
            } else if (c == '=') {
                value += flag * sign * num;

                flag = -flag;
                //reset
                num = 0;
                sign = 1;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        value += flag * sign * num;

        if (x == 0) return value == 0 ? INFINITE_SOLUTION : NO_SOLUTION;
        return "x=" + (-value) / x;
    }

    public static void main(String[] args) {
        No640SolveTheEquation solution = new No640SolveTheEquation();
        String result = solution.solveEquation("2x+3x-6x=x+2");
        System.out.println("result.equals(\"x=-1\") = " + result.equals("x=-1"));
        result = solution.solveEquation("1+1=x");
        System.out.println("result.equals(\"x=2\") = " + result.equals("x=2"));
    }
}
