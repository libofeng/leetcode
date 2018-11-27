package com.lintcode.string;

public class No415ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cl = s.charAt(left), cr = s.charAt(right);

            if (!Character.isLetterOrDigit(cl)) left++;
            else if (!Character.isLetterOrDigit(cr)) right--;
            else if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }
}
