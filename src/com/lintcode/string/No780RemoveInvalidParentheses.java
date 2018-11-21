package com.lintcode.string;

import java.util.*;

public class No780RemoveInvalidParentheses {

    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    // BFS
    public List<String> removeInvalidParentheses(String s) {
        final List<String> R = new LinkedList<>();
        final Queue<String> q = new LinkedList<>();
        final Set<String> visited = new HashSet<>();

        q.offer(s);
        visited.add(s);
        while (!q.isEmpty()) {
            String t = q.poll();
            if (isValid(t)) R.add(t);
            if (R.size() > 0) continue;

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')') continue;
                String next = t.substring(0, i) + t.substring(i + 1);
                if (visited.add(next)) q.offer(next);
            }
        }

        return R;
    }

    // DFS
    public List<String> removeInvalidParentheses2(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            if (left == 0) right += c == ')' ? 1 : 0;
            else left -= c == ')' ? 1 : 0;
        }
        List<String> R = new LinkedList<>();

        helper(s, 0, left, right, R);
        return R;
    }

    private void helper(String s, int start, int left, int right, List<String> R) {
        if (left == 0 && right == 0) {
            if (isValid(s)) R.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (left > 0 && s.charAt(i) == '(') {
                helper(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, R);
            }

            if (right > 0 && s.charAt(i) == ')') {
                helper(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, R);
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

    // DFS

    public List<String> removeInvalidParentheses3(String s) {
        List<String> R = new LinkedList<>();

        helper(s, 0, 0, new char[]{'(', ')'}, R);
        return R;
    }

    private void helper(String s, int lastI, int lastJ, char[] p, List<String> R) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) count++;
            else if (s.charAt(i) == p[1]) count--;
            if (count >= 0) continue;

            for (int j = lastJ; j < s.length(); j++) {
                if (s.charAt(j) == p[1] && (j == lastJ || s.charAt(j) != s.charAt(j - 1))) {
                    helper(s.substring(0, j) + s.substring(j + 1), i, j, p, R);
                }
            }

            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String reverse = sb.reverse().toString();

        if (p[0] == '(') helper(reverse, 0, 0, new char[]{')', '('}, R);
        else R.add(reverse);
    }
}
