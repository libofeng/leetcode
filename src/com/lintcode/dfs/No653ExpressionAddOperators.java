package com.lintcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No653ExpressionAddOperators {
    /**
     * @param num:    a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        final List<String> R = new LinkedList<>();

        for (int i = 1; i <= num.length(); i++) {
            long n = Long.parseLong(num.substring(0, i));
            helper(num, target, R, i, n, "" + n);
        }

        return R;
    }

    private void helper(String num, int target, List<String> R, int start, long expression, String path) {
        if (start == num.length()) {
            if (expression == target) R.add(path);
            return;
        }

        for (int i = start + 1; i <= num.length(); i++) {
            long n = Long.parseLong(num.substring(start, i));

            helper(num, target, R, i, expression - n, path + "-" + n);
            helper(num, target, R, i, expression + n, path + "+" + n);
            helper(num, target, R, i, expression * n, path + "*" + n);
        }
    }
}
