package com.leetcode.string;

import java.util.*;

public class No301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> result = new ArrayList<>();
        final Set<String> set = new HashSet<>();
        final Queue<String> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) result.add(str);
            if (result.size() > 0) continue;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;

                String next = str.substring(0, i) + str.substring(i + 1);
                if (set.add(next)) q.offer(next);
            }
        }

        return result;
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

    public static void main(String[] args) {
        No301RemoveInvalidParentheses solution = new No301RemoveInvalidParentheses();
        List<String> list = solution.removeInvalidParentheses(")(");

        System.out.println("list = " + list);
    }
}
