package com.leetcode.string;

public class No125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);
            if (!Character.isLetterOrDigit(l)) left++;
            else if (!Character.isLetterOrDigit(r)) right--;
            else if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }
}
