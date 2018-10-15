package com.leetcode.dp;

import java.util.LinkedList;
import java.util.List;

public class No140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                if (f[i]) break;
                int wl = w.length();
                if (i >= wl && f[i - wl] && s.substring(i - wl, i).equals(w)) f[i] = true;
            }
        }

        final List<String> R = new LinkedList<>();
        dfs(s, wordDict, R, new LinkedList<>(), f, s.length());

        return R;
    }

    private void dfs(String s, List<String> wd, List<String> R, LinkedList<String> list, boolean[] f, int end) {
        if (!f[end]) return;

        if (end == 0) {
            StringBuilder builder = new StringBuilder();
            for (String w : list) builder.append(w).append(" ");
            builder.deleteCharAt(builder.length() - 1);
            R.add(builder.toString());
            return;
        }

        for (String w : wd) {
            if (s.substring(0, end).endsWith(w)) {
                list.addFirst(w);
                dfs(s, wd, R, list, f, end - w.length());
                list.removeFirst();
            }
        }
    }
}
