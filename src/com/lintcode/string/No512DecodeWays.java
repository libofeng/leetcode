package com.lintcode.string;

public class No512DecodeWays {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;

        int left1 = 1, left2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int count = 0;
            if (Integer.parseInt(s.substring(i - 1, i)) != 0) count += left2;

            int n = Integer.parseInt(s.substring(i - 2, i));
            if (n >= 10 && n <= 26) count += left1;

            left1 = left2;
            left2 = count;
        }

        return left2;
    }
}
