package com.leetcode.array;

public class No9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int revs = 0;
        while (x > revs) {
            revs = revs * 10 + x % 10;
            x /= 10;
        }

        return x == revs || x == revs / 10;
    }
}
