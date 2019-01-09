package com;

public class KMP {
    // 此方法得到的是最长公共前缀后缀数组，而不真正意义上的Next数组
    private int[] next(String pattern) {
        final int[] next = new int[pattern.length()];

        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) j = next[j - 1];
            next[i] = pattern.charAt(j) == pattern.charAt(i) ? ++j : j;
        }

        return next;
    }

    public int index(String text, String pattern) {
        final int[] next = next(pattern);

        for (int i = 0, j = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) j = next[j - 1];
            if (text.charAt(i) == pattern.charAt(j)) j++;
            if (j == pattern.length()) return i + 1 - j;
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
