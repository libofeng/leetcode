package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class No93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        final List<String> R = new LinkedList<>();
        if (s.length() > 12) return R;

        dfs(s, R, 0, new LinkedList<>());

        return R;
    }

    private void dfs(String s, List<String> R, int start, LinkedList<String> list) {
        if (list.size() == 4) {
            if (start != s.length()) return;

            StringBuilder builder = new StringBuilder();
            for (String i : list) builder.append(i).append(".");
            builder.deleteCharAt(builder.length() - 1);
            R.add(builder.toString());
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String item = s.substring(start, i + 1);
            if (i > start && s.charAt(start) == '0') break;

            int n = Integer.parseInt(item);
            if (n < 0 || n > 255) break;

            list.add(item);
            dfs(s, R, i + 1, list);
            list.removeLast();
        }
    }
}
