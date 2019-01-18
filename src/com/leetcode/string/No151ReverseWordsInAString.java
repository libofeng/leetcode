package com.leetcode.string;

public class No151ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        int lo = 0, hi = words.length - 1;
        while (lo < hi) {
            String tmp = words[lo];
            words[lo++] = words[hi];
            words[hi--] = tmp;
        }

        return String.join(" ", words);
    }


    public String reverseWords2(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();

        int end = s.length();
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, end)).append(" ");

                i--;
                while (i >= 0 && s.charAt(i) == ' ') i--;
                end = i + 1;
            } else i--;
        }
        sb.append(s.substring(0, end)).append(" ");
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
