package com.leetcode.string;

public class No91DecodeWays {

    public int numDecodings(String s) {
        if (s.isEmpty()) return 1;
        if (s.charAt(0) == '0') return 0;


        int ways = 0, n1 = ways(s.charAt(0)), n2 = 0;
        if (n1 > 0) ways += n1 * numDecodings(s.substring(1));

        if (s.length() > 1) n2 = ways(s.charAt(0), s.charAt(1));
        if (n2 > 0) ways += n2 * numDecodings(s.substring(2));

        return ways;
    }

    public int numDecodings2(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] += dp[i - 1] * ways(s.charAt(i - 1));
            if (i > 1) dp[i] += dp[i - 2] * ways(s.charAt(i - 2), s.charAt(i - 1));
        }

        return dp[s.length()];
    }

    public int numDecodings3(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int oneChar = 1, twoChar = 0;
        for (int i = 1; i <= s.length(); i++) {
            int count = oneChar * ways(s.charAt(i - 1));
            if (i > 1) count += twoChar * ways(s.charAt(i - 2), s.charAt(i - 1));

            twoChar = oneChar;
            oneChar = count;
        }

        return oneChar;
    }

    private int ways(char c) {
        return c == '0' ? 0 : 1;
    }

    private int ways(char c1, char c2) {
        int n = 10 * (c1 - '0') + (c2 - '0');
        return n > 26 || n < 10 ? 0 : 1;
    }
}
