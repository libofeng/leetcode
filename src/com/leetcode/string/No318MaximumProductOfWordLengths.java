package com.leetcode.string;


public class No318MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        final int[] wordLetters = buildWordLetterBits(words);

        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int a = wordLetters[i], b = wordLetters[j];
                if ((a & b) == 0) maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }

        return maxProduct;
    }

    private int[] buildWordLetterBits(String[] words) {
        final int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int bit = 0;
            for (int j = 0; j < words[i].length(); j++) bit |= (1 << (words[i].charAt(j) - 'a'));
            bits[i] = bit;
        }
        return bits;
    }
}
