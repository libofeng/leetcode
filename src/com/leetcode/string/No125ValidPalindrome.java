package com.leetcode.string;

public class No125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;

            if (Character.toLowerCase(s.charAt(lo++)) != Character.toLowerCase(s.charAt(hi--))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        No125ValidPalindrome solution = new No125ValidPalindrome();
        boolean isPalindrome = solution.isPalindrome("0P");
        System.out.println("isPalindrome = " + isPalindrome);
    }
}
