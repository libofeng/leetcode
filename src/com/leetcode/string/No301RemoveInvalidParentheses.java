package com.leetcode.string;

import java.util.*;

public class No301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> list = new ArrayList<>();
        final Set<String> set = new HashSet<>();
        final Queue<String> q = new LinkedList<>();

        q.offer(s);
        while (!q.isEmpty()) {
            String sub = q.poll();
            if (isValid(sub)) list.add(sub);
            if (!list.isEmpty()) continue;

            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) != '(' && sub.charAt(i) != ')') continue;
                if (i > 0 && sub.charAt(i) == sub.charAt(i - 1)) continue;

                String next = sub.substring(0, i) + sub.substring(i + 1);
                if (!set.add(next)) q.offer(next);
            }
        }

        return list;
    }

    public List<String> removeInvalidParentheses2(String s) {
        final List<String> list = new ArrayList<>();

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }

        dfs(list, s, left, right, 0);
        return list;
    }

    private void dfs(List<String> list, String s, int left, int right, int start) {
        if (left == 0 && right == 0) {
            if (isValid(s)) list.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > start && c == s.charAt(i - 1)) continue;

            if (left > 0 && c == '(') {
                dfs(list, s.substring(0, i) + s.substring(i + 1), left - 1, right, i);
            } else if (right > 0 && c == ')') {
                dfs(list, s.substring(0, i) + s.substring(i + 1), left, right - 1, i);
            }
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else if (s.charAt(i) == ')' && --left < 0) return false;
        }

        return left == 0;
    }
}
