package com.leetcode.string;

import java.util.List;

public class No648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict.isEmpty()) return sentence;
        dict.sort((a, b) -> a.length() - b.length());

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String d : dict) {
                if (words[i].startsWith(d)) {
                    words[i] = d;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}
