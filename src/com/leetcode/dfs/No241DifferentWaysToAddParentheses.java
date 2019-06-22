package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class No241DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        final List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                final List<Integer> a = diffWaysToCompute(input.substring(0, i));
                final List<Integer> b = diffWaysToCompute(input.substring(i + 1));

                for (int p : a) {
                    for (int q : b) {
                        switch (c) {
                            case '+':
                                result.add(p + q);
                                break;
                            case '-':
                                result.add(p - q);
                                break;
                            case '*':
                                result.add(p * q);
                                break;
                            default:
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) result.add(Integer.parseInt(input));
        return result;
    }
}
