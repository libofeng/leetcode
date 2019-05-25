package com.leetcode.tree.trie;

import java.util.*;

public class No472ConcatenatedWords {
    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final List<String> result = new ArrayList<>();
        for (String w : words) insert(w);

        for (String w : words) if (search(w, 0, 0)) result.add(w);
        return result;
    }

    private boolean search(String w, int start, int words) {
        if (start >= w.length()) return words >= 2;

        List<Integer> ends = findWordEnds(w, start);
        for (int i = ends.size() - 1; i >= 0; i--) if (search(w, ends.get(i) + 1, words + 1)) return true;

        return false;
    }

    private List<Integer> findWordEnds(String w, int start) {
        final List<Integer> ends = new ArrayList<>();
        TrieNode current = root;
        for (int i = start; i < w.length(); i++) {
            char c = w.charAt(i);
            if (current.children[c - 'a'] == null) return ends;
            current = current.children[c - 'a'];
            if (current.isWord) ends.add(i);
        }

        return ends;
    }

    private void insert(String w) {
        TrieNode current = root;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    // Use HashSet to build prefix
    public static List<String> findAllConcatenatedWordsInADict2(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
