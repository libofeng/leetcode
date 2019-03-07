package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No30SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return result;

        final Map<String, Integer> dict = new HashMap<>();
        final Map<String, Integer> counter = new HashMap<>();
        for (String w : words) dict.put(w, dict.getOrDefault(w, 0) + 1);

        final int wordLen = words[0].length(), subLen = wordLen * words.length;
        for (int i = 0; i <= s.length() - subLen; i++) {
            counter.clear();
            if (isMatch(s, i, wordLen, subLen, dict, counter)) result.add(i);
        }
        return result;
    }

    // assuming K words and the avg len of a word is KW.
    // Time complexity: O(K), Space complexity: O(KW)
    private boolean isMatch(String s, int start, int wordLen, int subLen, Map<String, Integer> dict, Map<String, Integer> counter) {
        for (int i = start; i < start + subLen; i += wordLen) {
            String w = s.substring(i, i + wordLen);
            if (!dict.containsKey(w)) return false;
            counter.put(w, counter.getOrDefault(w, 0) + 1);
            if (counter.get(w) > dict.get(w)) return false;
        }

        return true;
    }
}
