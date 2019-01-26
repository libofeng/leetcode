package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(), list = new ArrayList<>();

        int totalCharacters = 0;
        for (String word : words) {
            if (totalCharacters + word.length() + list.size() > maxWidth) {
                result.add(justifyLine(list, totalCharacters, maxWidth));
                list = new ArrayList<>();
                list.add(word);
                totalCharacters = word.length();
            } else {
                list.add(word);
                totalCharacters += word.length();
            }
        }
        result.add(justifyLastLine(list, maxWidth));

        return result;
    }

    private String justifyLine(List<String> words, int totalCharacters, int maxWidth) {
        if (words.size() == 1) return justifyLastLine(words, maxWidth);

        int slots = words.size() - 1, totalSpaces = maxWidth - totalCharacters;

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w);
            if (slots == 0) break;

            int slotsSpaces = totalSpaces / slots + (totalSpaces % slots == 0 ? 0 : 1);
            for (int i = 0; i < Math.min(slotsSpaces, totalSpaces); i++) sb.append(" ");

            slots--;
            totalSpaces -= slotsSpaces;
        }

        return sb.toString();
    }


    private String justifyLastLine(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append(" ");

        while (sb.length() < maxWidth) sb.append(" ");
        if (sb.length() > maxWidth) sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
