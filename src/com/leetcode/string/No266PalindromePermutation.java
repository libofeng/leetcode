package com.leetcode.string;

public class No266PalindromePermutation {
    /*
    Given a string, determine if a permutation of the string could form a palindrome.

    Example 1:

    Input: "code"
    Output: false
    Example 2:

    Input: "aab"
    Output: true
    Example 3:

    Input: "carerac"
    Output: true

     */

    boolean isPalindrome(String s) {
        final int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c - 'a']++;
        }

        int odd = 0;
        for (int c : counter) if (c % 2 == 1 && ++odd > 1) return false;
        return true;
    }

    public static void main(String[] args) {
        boolean result;

        No266PalindromePermutation solution = new No266PalindromePermutation();
        result = solution.isPalindrome("code");
        System.out.println("result = " + result);

        result = solution.isPalindrome("aab");
        System.out.println("result = " + result);

        result = solution.isPalindrome("carerac");
        System.out.println("result = " + result);
    }
}
