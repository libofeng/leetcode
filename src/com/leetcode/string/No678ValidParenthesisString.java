package com.leetcode.string;

public class No678ValidParenthesisString {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

    private boolean checkValidString(String s, int start, int left) {
        if (left < 0) return false;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')') {
                if (left-- == 0) return false;
            } else {
                return checkValidString(s, i + 1, left + 1)
                        || checkValidString(s, i + 1, left)
                        || checkValidString(s, i + 1, left - 1);
            }
        }

        return left == 0;
    }

    // https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass
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
