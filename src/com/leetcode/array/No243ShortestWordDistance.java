package com.leetcode.array;

import java.util.TreeSet;

public class No243ShortestWordDistance {
    // https://www.cnblogs.com/lightwindy/p/9736289.html
    // O(N), O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        int d = Integer.MAX_VALUE, m = -1, n = -1;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word1) && !words[i].equals(word2)) continue;

            if (words[i].equals(word1)) m = i;
            else if (words[i].equals(word2)) n = i;

            if (m >= 0 && n >= 0) d = Math.min(d, Math.abs(m - n));
        }
        return d;
    }

    // https://www.cnblogs.com/grandyang/p/5187041.html
    // O(N), O(1)
    public int shortestDistance2(String[] words, String word1, String word2) {
        int d = Integer.MAX_VALUE, prev = -1;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word1) && !words[i].equals(word2)) continue;

            if (prev >= 0 && !words[prev].equals(words[i])) {
                d = Math.min(d, i - prev);
            }
            prev = i;
        }
        return d;
    }


    // O(N^2), O(N)
    public int shortestDistance3(String[] words, String word1, String word2) {
        TreeSet<Integer> set1 = new TreeSet<>(), set2 = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) set1.add(i);
            if (words[i].equals(word2)) set2.add(i);
        }

        int d = Integer.MAX_VALUE;
        for (int d1 : set1) {
            for (int d2 : set2) d = Math.min(d, Math.abs(d1 - d2));
        }

        return d;
    }

    // O(N * LogN), O(N)
    /*
    lower     返回小于        给定元素的元素
    floor     返回小于等于   给定元素的元素
    ceiling 返回大于等于      给定元素的元素
    higher  返回大于       给定元素的元素
    */
    public int shortestDistance4(String[] words, String word1, String word2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < words.length; i++) if (words[i].equals(word1)) set.add(i);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!word2.equals(words[i])) continue;

            Integer lo = set.lower(i), hi = set.higher(i);
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
