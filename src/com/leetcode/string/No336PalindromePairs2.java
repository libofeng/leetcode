package com.leetcode.string;

import java.util.*;

public class No336PalindromePairs2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {
                String word1 = word.substring(0, j), word2 = word.substring(j);

                if (isPalindrome(word1)) {
                    String right = reverse(word2);
                    if (map.containsKey(right) && i != map.get(right)) {
                        list.add(Arrays.asList(map.get(right), i));
                    }
                }

                if (isPalindrome(word2) && !word2.isEmpty()) {
                    String left = reverse(word1);
                    if (map.containsKey(left) && i != map.get(left)) {
                        list.add(Arrays.asList(i, map.get(left)));
                    }
                }
            }
        }

        return list;
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) if (word.charAt(left++) != word.charAt(right--)) return false;
        return true;
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}
