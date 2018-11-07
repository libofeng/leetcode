package com.lintcode.string;

import java.util.Arrays;
import java.util.Comparator;

public class No819WordSorting {
    /**
     * @param alphabet: the new alphabet
     * @param words:    the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        int[] dict = new int[26];
        for (int i = 0; i < alphabet.length; i++) dict[alphabet[i] - 'a'] = i;

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int len1 = s1.length(), len2 = s2.length(), len = Math.min(len1, len2);
                for (int i = 0; i < len; i++) {
                    int n1 = dict[s1.charAt(i) - 'a'], n2 = dict[s2.charAt(i) - 'a'];
                    if (n1 != n2) return n1 - n2;
                }

                return len1 - len2;
            }
        });

        return words;
    }
}
