package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No247StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> list = n % 2 == 1 ? Arrays.asList("1", "8", "0") : Arrays.asList("");
        if (n <= 1) return list;

        final List<String> R = new ArrayList<>();
        for (String path : list) R.addAll(getNumber(n, path));

        return R;
    }

    private List<String> getNumber(int n, String path) {
        char[] chars = {'0', '1', '6', '8', '9'};
        List<String> numbers = new ArrayList<>();
        dfs(chars, numbers, n, 0, path);
        return numbers;
    }

    private void dfs(char[] chars, List<String> numbers, int n, int start, String path) {
        if (path.length() == n) {
            if (n == 1 || path.charAt(0) != '0') numbers.add(path);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            dfs(chars, numbers, n, i, chars[i] + path + rotate69(chars[i]));
        }
    }

    private char rotate69(char c) {
        if (c == '9') return '6';
        if (c == '6') return '9';
        return c;
    }
}
