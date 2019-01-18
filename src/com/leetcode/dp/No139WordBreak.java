package com.leetcode.dp;

import java.util.*;

public class No139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;

        for (String w : wordDict) if (s.startsWith(w) && wordBreak(s.substring(w.length()), wordDict)) return true;
        return false;
    }


    Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        if (cache.containsKey(s)) return cache.get(s);

        for (String w : wordDict) {
            if (s.startsWith(w) && wordBreak(s.substring(w.length()), wordDict)) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);
        return false;
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        final Set<String> set = new HashSet<>(wordDict);

        final boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) if (dp[i] && set.contains(s.substring(i, j))) dp[j] = true;
        }

        return dp[dp.length - 1];
    }

    public boolean wordBreak4(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        final int m = s.length();
        final boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 1; i <= m; i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && s.substring(start, i).equals(w) && dp[start]) dp[i] = true;
            }
        }

        return dp[m];
    }

}
