package com.leetcode.string;

import java.util.List;

public class No524LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : (b.length() - a.length()));
        for (String w : d) if (isSubsequence(s, w)) return w;

        return "";
    }

    private boolean isSubsequence(String s, String w) {
        int j = 0;
        for (int i = 0; i < s.length() && j < w.length(); i++) if (s.charAt(i) == w.charAt(j)) j++;

        return j == w.length();
    }

    public String findLongestWord2(String s, List<String> d) {
        String longest = "";
        for(String w : d){
            if(!isSubsequence(s, w)) continue;
            if(w.length() > longest.length()
                    || (w.length() == longest.length() && w.compareTo(longest) < 0)) longest = w;
        }

        return longest;
    }
}
