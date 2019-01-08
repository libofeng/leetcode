package com;

public class KMP {
    private int[] next(String pattern) {
        final int[] next = new int[pattern.length()];

        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) j = next[j - 1];
            if (pattern.charAt(j) == pattern.charAt(i)) j++;
            next[i] = j;
        }

        return next;
    }

    public int index(String text, String pattern) {
        final int[] next = next(pattern);

        for (int i = 0, j = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) j = next[j - 1];
            if (text.charAt(i) == pattern.charAt(j)) j++;
            if (j == pattern.length()) return i - j + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "abababc", pattern = "abcd";
        int index = kmp.index(text, pattern);

        System.out.println("index = " + index);
        System.out.println(index == text.indexOf(pattern));
    }
}
