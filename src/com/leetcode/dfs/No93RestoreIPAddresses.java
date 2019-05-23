package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class No93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() > 12) return result;

        dfs(s, 0, 0, result, "");
        return result;
    }

    private void dfs(String s, int start, int level, List<String> result, String ip) {
        if (start == s.length() || level == 4) {
            if (start == s.length() && level == 4) result.add(ip);
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') return;

            String token = s.substring(start, i + 1);
            int num = Integer.parseInt(token);
            if (num >= 0 && num <= 255) {
                String nextIp = ip;
                if (level > 0) nextIp += ".";
                nextIp += token;

                dfs(s, i + 1, level + 1, result, nextIp);
            }
        }
    }
}
