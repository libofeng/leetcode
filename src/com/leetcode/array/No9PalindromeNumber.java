package com.leetcode.array;

import java.util.Stack;

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


    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int xx = x;
        Stack<Integer> stack = new Stack<>();
        while (xx > 0) {
            stack.push(xx % 10);
            xx /= 10;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != x % 10) return false;
            x /= 10;
        }

        return true;
    }
}
