package com.leetcode.dp;

import java.util.List;

public class No139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        final boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                if (f[i]) break;
                int wLen = w.length();
                if (i >= wLen && f[i - wLen] && w.equals(s.substring(i - wLen, i))) f[i] = true;
            }
        }

        return f[s.length()];
    }
}
