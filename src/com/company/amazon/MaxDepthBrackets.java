package com.company.amazon;

public class MaxDepthBrackets {

    int maxDepth(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxDepth = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') maxDepth = Math.max(maxDepth, ++left);
            else {
                if (left > 0) left--;
            }
        }

        return maxDepth - left;
    }

    public static void main(String[] args) {
        MaxDepthBrackets solution = new MaxDepthBrackets();
        int d;

        d = solution.maxDepth("((()))");
        System.out.println("expected:3, d = " + d);

        d = solution.maxDepth("((()))(())");
        System.out.println("expected:3, d = " + d);

        d = solution.maxDepth("(())(())");
        System.out.println("expected:2, d = " + d);

        d = solution.maxDepth("");
        System.out.println("expected:0, d = " + d);

        d = solution.maxDepth("()))))");
        System.out.println("expected:1, d = " + d);
    }
}
