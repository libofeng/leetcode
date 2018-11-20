package com.lintcode.string;

public class No891ValidPalindromeII {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return isValid(s, l - 1, r) || isValid(s, l, r + 1);
        return true;
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
