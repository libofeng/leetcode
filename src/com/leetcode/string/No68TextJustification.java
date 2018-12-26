package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> R = new ArrayList<>();

        int totalWordLen = 0;
        List<String> lineWords = new ArrayList<>();
        for (String w : words) {
            if (totalWordLen + lineWords.size() + w.length() > maxWidth) {
                R.add(fillLine(lineWords, totalWordLen, maxWidth));

                totalWordLen = 0;
                lineWords = new ArrayList<>();
            }

            totalWordLen += w.length();
            lineWords.add(w);
        }
        if (!lineWords.isEmpty()) R.add(fillLastLine(lineWords, maxWidth));

        return R;
    }

    private String fillLine(List<String> words, int totalWordLen, int maxWidth) {
        int slots = words.size() - 1, extraSpacers = maxWidth - totalWordLen - slots;
        if (slots == 0) return fillLastLine(words, maxWidth);

        int extraSlotSpacers = extraSpacers / slots;
        int otherSpacers = extraSpacers - extraSlotSpacers * slots;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i != words.size() - 1) {
                sb.append(" ");
                for (int k = 0; k < extraSlotSpacers; k++) sb.append(" ");
                if (otherSpacers-- > 0) sb.append(" ");
            }
        }

        return sb.toString();
    }


    private String fillLastLine(List<String> words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) sb.append(word).append(" ");
        sb.deleteCharAt(sb.length() - 1);

        int spacers = maxWidth - sb.length();
        while (spacers-- > 0) sb.append(" ");

        return sb.toString();
    }
}
