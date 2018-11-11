package com.lintcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No1361TextJustification {
    /**
     * @param words:    an array of string
     * @param maxWidth: a integer
     * @return: format the text such that each line has exactly maxWidth characters and is fully
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> R = new LinkedList<>();

        List<String> list = new ArrayList<>();
        int chars = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (chars + list.size() + w.length() >= maxWidth) {
                if (chars + list.size() + w.length() == maxWidth) {
                    list.add(w);
                    chars += w.length();
                    R.add(build(list, chars, maxWidth, false));
                    list = new ArrayList<>();
                    chars = 0;
                } else {
                    R.add(build(list, chars, maxWidth, false));
                    list = new ArrayList<>();
                    list.add(w);
                    chars = w.length();
                }
            } else {
                list.add(w);
                chars += w.length();
            }
        }

        if (list.size() > 0) R.add(build(list, chars, maxWidth, true));
        return R;
    }

    private String build(List<String> list, int chars, int maxWidth, boolean last) {
        int spaces = maxWidth - chars - list.size() + 1;
        int words = list.size(), slots = words - 1;
        ;

        final StringBuilder sb = new StringBuilder();
        if (words == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < spaces; i++) sb.append(" ");
            return sb.toString();
        }

        int avg = last ? 0 : spaces / slots, total = 0;
        if (!last && spaces % slots != 0) avg += 1;
        for (int j = 0; j < words; j++) {
            sb.append(list.get(j)).append(" ");
            for (int i = 0; i < avg && total < spaces; i++, total++) sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        for (int i = total; i < spaces; i++) sb.append(" ");
        return sb.toString();
    }
}
