package com.leetcode.dp;

public class No639DecodeWaysII {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        final int MOD = 1000000007;

        final long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = ways(s.charAt(0));
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (ways(s.charAt(i - 1)) * dp[i - 1] + ways(s.charAt(i - 2), s.charAt(i - 1)) * dp[i - 2]) % MOD;
        }

        return (int) dp[dp.length - 1];
    }

    public int numDecodings2(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        return (int) helper(s, 0);
    }

    private long helper(String s, int start) {
        if (start == s.length()) return 1;

        long count = 0;
        char c1 = s.charAt(start);
        count += ways(c1) * helper(s, start + 1);
        if (start + 1 < s.length()) {
            char c2 = s.charAt(start + 1);
            count += ways(c1, c2) * helper(s, start + 2);
        }
        return count % 1000000007;
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
            return c1 == '1' ? 9 : 6;
        }

        int n = (c1 - '0') * 10 + c2 - '0';
        return n >= 10 && n <= 26 ? 1 : 0;
    }
}
