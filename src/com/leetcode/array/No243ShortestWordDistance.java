package com.leetcode.array;

import java.util.TreeSet;

public class No243ShortestWordDistance {
    // https://www.cnblogs.com/lightwindy/p/9736289.html
    // O(N), O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        int d = Integer.MAX_VALUE, m = -1, n = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) m = i;
            else if (words[i].equals(word2)) n = i;
            else continue;

            if (m >= 0 && n >= 0) d = Math.min(d, Math.abs(m - n));
        }
        return d;
    }

    // O(N * LogN), O(N)
    public int shortestDistance2(String[] words, String word1, String word2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < words.length; i++) if (words[i].equals(word1)) set.add(i);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word2)) continue;
            Integer lo = set.floor(i), hi = set.ceiling(i);
            if (lo != null) d = Math.min(d, Math.abs(i - lo));
            if (hi != null) d = Math.min(d, Math.abs(i - hi));
        }
        return d;
    }

    public static void main(String[] args) {
        final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        No243ShortestWordDistance solution = new No243ShortestWordDistance();
        int d = solution.shortestDistance(words, "coding", "practice");
        System.out.println("passed=" + (d == 3));

        d = solution.shortestDistance(words, "makes", "coding");
        System.out.println("passed=" + (d == 1));
    }
}
