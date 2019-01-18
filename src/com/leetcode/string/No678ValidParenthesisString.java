package com.leetcode.string;

public class No678ValidParenthesisString {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int start, int left) {
        if (start == s.length()) return left == 0;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')') {
                if (left-- == 0) return false;
            } else {
                if (left > 0 && helper(s, i + 1, left - 1)) return true;
                else if (helper(s, i + 1, left + 1)) return true;
            }
        }

        return left == 0;
    }


    public boolean checkValidString2(String s) {
        int lo = 0, hi = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                if (lo > 0) lo--;
                hi--;
            } else {
                if (lo > 0) lo--;
                hi++;
            }

            if (hi < 0) return false;
        }

        return lo == 0;
    }

}
