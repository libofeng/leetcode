package com.leetcode.math;

public class No479LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        final int MOD = 1337;
        long hi = (long) Math.pow(10, n) - 1, lo = hi / 10;

        for (long num = hi; num > lo; num--) {
            long left = num, right = 0;
            for (long i = num; i != 0; right = right * 10 + i % 10, left *= 10, i /= 10) ;
            long palindrome = left + right;

            for (long i = hi; i > lo; i--) {
                long j = palindrome / i;
                if (j > i) break;
                if (palindrome % i == 0) return (int) (palindrome % MOD);
            }
        }

        return 9;
    }
}
