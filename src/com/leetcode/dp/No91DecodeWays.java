package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class No91DecodeWays {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int start) {
        if (cache.containsKey(start)) return cache.get(start);
        if (start == s.length()) return 1;

        int count = 0;
        if (s.charAt(start) != '0') {
            count += helper(s, start + 1);

            if (start + 2 <= s.length()) {
                int n2 = Integer.parseInt(s.substring(start, start + 2));
                if (n2 >= 10 && n2 <= 26) count += helper(s, start + 2);
            }
        }

        cache.put(start, count);
        return count;
    }


    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];

            int n2 = Integer.parseInt(s.substring(i - 2, i));
            if (n2 >= 10 && n2 <= 26) dp[i] += dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    // simplified from numDecodings2
    public int numDecodings3(String s) {
        if (s.charAt(0) == '0') return 0;

        int left1 = 1, left2 = 1;
        for (int i = 2; i <= s.length(); i++) {
            int current = 0;
            if (s.charAt(i - 1) != '0') current += left2;

            int n2 = Integer.parseInt(s.substring(i - 2, i));
            if (n2 >= 10 && n2 <= 26) current += left1;

            left1 = left2;
            left2 = current;
        }

        return left2;
    }
}
