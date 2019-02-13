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
        StringBuilder sb = new StringBuilder();

        int right = s.length() - 1;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') right--;

            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') left--;

            if (right > left) sb.append(s.substring(left + 1, right + 1)).append(" ");
            right = left;
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
