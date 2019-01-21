package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No282ExpressionAddOperators {
    // 1. Use long for numbers and expression values to avoid overflow
    // 2. Skip invalid number starts with "0"
    // 3. mind the edge case of the 1st number

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, result, 0, 0, 0, "");
        return result;
    }

    private void helper(String s, int target, List<String> result, int index, long expression, long last, String path) {
        if (index == s.length()) {
            if (expression == target) result.add(path);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            long n = Long.parseLong(s.substring(index, i + 1));

            if (index == 0) helper(s, target, result, i + 1, n, n, path + n);
            else {
                helper(s, target, result, i + 1, expression + n, n, path + "+" + n);
                helper(s, target, result, i + 1, expression - n, -n, path + "-" + n);
                helper(s, target, result, i + 1, expression - last + last * n, last * n, path + "*" + n);
            }

            if (n == 0) break;
        }

    }
}
