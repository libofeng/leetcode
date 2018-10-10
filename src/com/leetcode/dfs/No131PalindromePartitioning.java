package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        final List<List<String>> R = new LinkedList<>();
        dfs(s, 0, R, new LinkedList<>());
        return R;
    }

    private void dfs(String s, int start, List<List<String>> R, List<String> list) {
        if (start == s.length()) {
            R.add(list);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                List<String> l = new LinkedList<>(list);
                l.add(s.substring(start, i + 1));
                dfs(s, i + 1, R, l);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
