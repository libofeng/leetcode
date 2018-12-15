package com.lintcode.string;

public class No676DecodeWaysII {

    /**
     * @param s: a message being encoded
     * @return: an integer
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        final int MOD = 1000000007;
        final long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1] * ways(s.charAt(i - 1));
            if (i > 1) dp[i] += dp[i - 2] * ways(s.charAt(i - 2), s.charAt(i - 1));
            dp[i] %= MOD;
        }
        return (int) dp[dp.length - 1];
    }

    private int ways(char c) {
        if (c == '0') return 0;
        if (c == '*') return 9;
        return 1;
    }

    private int ways(char c1, char c2) {
        if (c1 == '0') return 0;
        if (c1 == '*' && c2 == '*') return 15;
        if (c1 == '*') return c2 <= '6' ? 2 : 1;
        if (c2 == '*') {
            if (c1 > '2') return 0;
            else return c1 == '1' ? 9 : 6;
        }

        int n = (c1 - '0') * 10 + c2 - '0';
        return (n <= 26 && n >= 10) ? 1 : 0;
    }
}
