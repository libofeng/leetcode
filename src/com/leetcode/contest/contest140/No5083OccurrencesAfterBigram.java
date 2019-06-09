package com.leetcode.contest.contest140;

import java.util.ArrayList;
import java.util.List;

public class No5083OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        if (text == null || text.isEmpty()) return new String[0];
        String[] words = text.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) list.add(words[i]);
        }

        return list.toArray(new String[list.size()]);
    }
}
