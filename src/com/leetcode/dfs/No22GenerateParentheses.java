package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, result, "");
        return result;
    }

    private void dfs(int left, int right, List<String> result, String s) {
        if (left == 0 && right == 0) result.add(s);
        else {
            if (left > 0) dfs(left - 1, right, result, s + "(");
            if (right > left) dfs(left, right - 1, result, s + ")");
        }
    }
}
