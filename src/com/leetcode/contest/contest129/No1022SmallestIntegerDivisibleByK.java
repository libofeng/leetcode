package com.leetcode.contest.contest129;

import java.util.HashSet;
import java.util.Set;

public class No1022SmallestIntegerDivisibleByK {
    /*
    Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.

    Return the length of N.  If there is no such N, return -1.



    Example 1:

    Input: 1
    Output: 1
    Explanation: The smallest answer is N = 1, which has length 1.
    Example 2:

    Input: 2
    Output: -1
    Explanation: There is no such positive integer N divisible by 2.
    Example 3:

    Input: 3
    Output: 3
    Explanation: The smallest answer is N = 111, which has length 3.
     */

    public int smallestRepunitDivByK(int K) {
        int x = 0;
        for (int len = 1; len <= 1000000; len++) {
            x = (x * 10 + 1) % K;
            if (x == 0) return len;
        }
        return -1;
    }

    public int smallestRepunitDivByK2(int K) {
        final Set<Integer> seen = new HashSet<>();
        int x = 1, len = 1;

        while (x % K != 0) {
            if (!seen.add(x)) return -1;
            x = (x * 10 + 1) % K;
        }
        return len;
    }

    public static void main(String[] args) {
        No1022SmallestIntegerDivisibleByK solution = new No1022SmallestIntegerDivisibleByK();
        int result = solution.smallestRepunitDivByK2(2);
        System.out.println("result = " + result);
    }
}
