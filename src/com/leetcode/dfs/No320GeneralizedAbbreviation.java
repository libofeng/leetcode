package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class No320GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        final List<String> result = new ArrayList<>();

        dfs(word, result, 0, 0, "");
        return result;
    }

    private void dfs(String word, List<String> result, int start, int count, String abbr) {
        if (start == word.length()) {
            if (count > 0) abbr += count;
            result.add(abbr);
            return;
        }

        dfs(word, result, start + 1, count + 1, abbr);
        dfs(word, result, start + 1, 0, abbr + (count == 0 ? "" : count) + word.charAt(start));
    }
}
