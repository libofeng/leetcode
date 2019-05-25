package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No131PalindromePartitioning {
    // Time: O(N!), Space: O(N)
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


    // Use DP to pre-calculate the valid palindrome substring.
    // Time: O(N!), Space: O(N)
    public List<List<String>> partition2(String s) {
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) dp[j][i] = true;
            }
        }

        final List<List<String>> result = new ArrayList<>();
        dfs(s, 0, dp, result, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int start, boolean[][] dp, List<List<String>> result, List<String> list) {
        if (start == s.length()) result.add(new ArrayList<>(list));

        for (int i = start; i < s.length(); i++) {
            if (!dp[start][i]) continue;
            list.add(s.substring(start, i + 1));
            dfs(s, i + 1, dp, result, list);
            list.remove(list.size() - 1);
        }
    }
}
