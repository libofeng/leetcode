package com.leetcode.contest.contest151;

public class No1170CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        final int n = queries.length;
        final int[] result = new int[n];
        final int[] fw = new int[words.length];
        for (int i = 0; i < words.length; i++) fw[i] = f(words[i]);

        for (int i = 0; i < n; i++) {
            int fq = f(queries[i]);
            result[i] = count(fw, fq);
        }

        return result;
    }

    private int count(int[] fw, int fq) {
        int count = 0;
        for (int f : fw) if (f > fq) count++;
        return count;
    }

    private int f(String w) {
        char min = w.charAt(0);
        int count = 1;
        for (int i = 1; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) count++;
        }

        return count;
    }
}
