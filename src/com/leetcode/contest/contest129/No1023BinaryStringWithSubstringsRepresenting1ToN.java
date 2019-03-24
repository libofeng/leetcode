package com.leetcode.contest.contest129;

import java.util.HashSet;
import java.util.Set;

public class No1023BinaryStringWithSubstringsRepresenting1ToN {

    /*
    Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
    return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

    Example 1:

    Input: S = "0110", N = 3
    Output: true


    Example 2:

    Input: S = "0110", N = 4
    Output: false
    */


    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String s = Integer.toBinaryString(i);
            if (!S.contains(s)) return false;
        }

        return true;
    }

    public boolean queryString2(String S, int N) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            for (int k = 0; k < 31; k++) {
                int j = i + k;
                if (j >= S.length()) break;

                int n = toInt(S, i, j);
                if (n > 0 && n <= N) set.add(n);
            }
        }

        return N == set.size();
    }

    private int toInt(String s, int start, int end) {
        int n = 0;
        for (int i = start; i <= end; i++) n = n * 2 + (s.charAt(i) - '0');
        return n;
    }
}
