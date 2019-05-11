package com.leetcode.string;

public class No824GoatLatin {
    public String toGoatLatin(String S) {
        if (S.isEmpty()) return S;

        final String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) process(words, i);
        return String.join(" ", words);
    }

    private void process(String[] words, int index) {
        final String w = words[index];
        boolean isVowel = true;

        final StringBuilder sb = new StringBuilder();
        char c = Character.toLowerCase(w.charAt(0));
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') sb.append(w.charAt(0));
        else isVowel = false;

        for (int i = 1; i < w.length(); i++) sb.append(w.charAt(i));
        if (!isVowel) sb.append(w.charAt(0));
        sb.append("ma");
        sb.append(getTailAs(index));

        words[index] = sb.toString();
    }

    private String getTailAs(int index) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) sb.append("a");
        return sb.toString();
    }
}
