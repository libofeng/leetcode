package com.lintcode.dp;

import java.util.Set;

public class No107WordBreak {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */

    public boolean wordBreak(String s, Set<String> dict) {
        int[] cache = new int[s.length() + 1];

        return wordBreak(s, dict, s.length(), cache);
    }

    private boolean wordBreak(String s, Set<String> dict, int end, int[] cache) {
        if (end == 0) return true;
        if (cache[end] != 0) return cache[end] == 1;

        for (String w : dict) {
            int start = end - w.length();
            if (start < 0) continue;
            if (w.equals(s.substring(start, end)) && wordBreak(s, dict, start, cache)) {
                cache[end] = 1;
                return true;
            }
        }

        cache[end] = -1;
        return false;
    }


    public boolean wordBreak2(String s, Set<String> dict) {
        return helper(s, dict, 0);
    }

    private boolean helper(String s, Set<String> dict, int start) {
        if (start == s.length()) return true;

        for (String w : dict) {
            if (!s.substring(start).startsWith(w)) continue;
            if (helper(s, dict, start + w.length())) return true;
        }

        return false;
    }


    // dp
    public boolean wordBreak3(String s, Set<String> dict) {
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String w : dict) {
                int start = i - w.length();
                if (start < 0) continue;
                if (w.equals(s.substring(start, i))) dp[i] |= dp[start];
            }
        }

        return dp[dp.length - 1];
    }
}
