package com.leetcode.contest.contest131;

import java.util.ArrayList;
import java.util.List;

public class No5018CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        final List<Boolean> result = new ArrayList<>();
        for (String q : queries) result.add(isMatch(q, pattern));

        return result;
    }

    private boolean isMatch(String q, String p) {
        int i = 0, j = 0;
        for (; i < q.length(); i++) {
            char c = q.charAt(i);

            if (Character.isUpperCase(c)) {
                if (j >= p.length() || c != p.charAt(j++)) return false;
            } else {
                if (j < p.length() && c == p.charAt(j)) j++;
            }
        }

        return i == q.length() && j == p.length();
    }
}
