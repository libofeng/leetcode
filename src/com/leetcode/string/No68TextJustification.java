package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(), list = new ArrayList<>();

        int wordChars = 0;
        for (String w : words) {
            if (wordChars + w.length() + list.size() > maxWidth) {
                result.add(build(list, wordChars, maxWidth));

                list = new ArrayList<>();
                wordChars = 0;
            }

            wordChars += w.length();
            list.add(w);
        }
        result.add(build(list, maxWidth));

        return result;
    }

    private String build(List<String> words, int wordChars, int maxWidth) {
        if (words.size() == 1) return build(words, maxWidth);
        final StringBuilder sb = new StringBuilder();

        final int slots = words.size() - 1, spaces = maxWidth - wordChars;
        int evenSpaces = spaces / slots, unevenSpaces = spaces % slots;

        for (String w : words) {
            sb.append(w);
            for (int i = 0; i < evenSpaces; i++) sb.append(" ");
            if (unevenSpaces-- > 0) sb.append(" ");
        }
        if (sb.length() > maxWidth) sb.setLength(maxWidth);

        return sb.toString();
    }

    private String build(List<String> words, int maxWidth) {
        final StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append(" ");

        while (sb.length() < maxWidth) sb.append(" ");
        if (sb.length() > maxWidth) sb.setLength(maxWidth);

        return sb.toString();
    }
}
