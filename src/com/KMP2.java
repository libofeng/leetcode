package com;

public class KMP2 {
    private int[] next(String pattern) {
        final int[] next = new int[pattern.length()];
        int k = -1, j = 0;
        next[0] = -1;

        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;

                if (pattern.charAt(k) == pattern.charAt(j)) next[j] = next[k]; // optimization
                else next[j] = k;
            } else k = next[k];
        }

        return next;
    }

    public int index(String text, String pattern) {
        final int[] next = next(pattern);
        int i = 0, j = 0;

        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }

        return j == pattern.length() ? i - j : -1;
    }

    public static void main(String[] args) {
        KMP2 kmp = new KMP2();
        String text = "abababc", pattern = "abcd";
        int index = kmp.index(text, pattern);

        System.out.println("index = " + index);
        System.out.println(index == text.indexOf(pattern));
    }
}
