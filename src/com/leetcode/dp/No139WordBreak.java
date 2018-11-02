package com.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    private boolean helper(String s, List<String> D, int start) {
        if (start == s.length()) return true;

        for (int i = start + 1; i <= s.length(); i++) {
            if (D.contains(s.substring(start, i)) && helper(s, D, i)) return true;
        }

        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        final Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        final boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 0; i<s.length(); i++){
            for(int j = i+1; j<=s.length();j++ ) if(dp[i] && set.contains(s.substring(i, j))) dp[j] = true;
        }

        return dp[dp.length-1];
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        final boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int wl = w.length(), start = i - wl;
                if (dp[i] || start < 0 || !dp[start]) continue;

                if (s.substring(start).startsWith(w)) dp[i] = true;
            }
        }

        return dp[dp.length - 1];
    }

}
