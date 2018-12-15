package com.lintcode.string;

public class No512DecodeWays {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        int left1 = 1, left2 = 1;
        for (int i = 1; i <= s.length(); i++) {
            int count = left1 * ways(s.charAt(i - 1));
            if (i > 1) count += left2 * ways(s.charAt(i - 2), s.charAt(i - 1));

            left2 = left1;
            left1 = count;
        }

        return left1;
    }

    private int ways(char c) {
        return c == '0' ? 0 : 1;
    }

    private int ways(char c1, char c2) {
        int n = (c1 - '0') * 10 + (c2 - '0');
        return n >= 10 && n <= 26 ? 1 : 0;
    }
}
