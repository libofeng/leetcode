package com.leetcode.array;

public class No245ShortestWordDistanceIII {
    // https://www.cnblogs.com/lightwindy/p/9736293.html
    public int shortestDistance(String[] words, String word1, String word2) {
        boolean sameWord = word1.equals(word2);

        int d = Integer.MAX_VALUE, m = -1, n = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) m = sameWord? n : i;
            if (words[i].equals(word2)) n = i;

            if (m >= 0 && n >= 0) d = Math.min(d, Math.abs(m - n));
        }
        return d;
    }


    public static void main(String[] args) {
        final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        No245ShortestWordDistanceIII solution = new No245ShortestWordDistanceIII();
        int d = solution.shortestDistance(words, "coding", "practice");
        System.out.println("passed=" + (d == 3));

        d = solution.shortestDistance(words, "makes", "coding");
        System.out.println("passed=" + (d == 1));

        d = solution.shortestDistance(words, "makes", "makes");
        System.out.println("passed=" + (d == 3));
    }
}
