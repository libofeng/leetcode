package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        final List<String> R = new LinkedList<>();

        dfs(R, n, n, new StringBuilder());

        return R;
    }

    private void dfs(List<String> R, int left, int right, StringBuilder builder) {
        if (left == 0 && right == 0) {
            R.add(builder.toString());
            return;
        }

        if (left > 0) {
            builder.append("(");
            dfs(R, left - 1, right, builder);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (right > 0 && left < right) {
            builder.append(")");
            dfs(R, left, right - 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
