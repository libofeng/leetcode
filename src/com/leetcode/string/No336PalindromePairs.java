package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No336PalindromePairs {
    class TrieNode {
        int wordIndex = -1;
        TrieNode[] children = new TrieNode[26];
        List<Integer> leftPalindromeWordIds;

        TrieNode() {
            leftPalindromeWordIds = new ArrayList<>();
        }
    }

    TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<Integer> selfPalindromeIds = getSelfPalindrome(words);

        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                for (int id : selfPalindromeIds) {
                    if (id == i) continue;
                    R.add(Arrays.asList(i, id));
                    R.add(Arrays.asList(id, i));
                }
            } else insert(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            for (int id : search(word, i)) if (i != id) R.add(Arrays.asList(i, id));
        }

        return R;
    }


    private void insert(String word, int i) {
        word = reverse(word);
        TrieNode current = root;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            if (isPalindrome(word, j + 1, word.length() - 1)) current.leftPalindromeWordIds.add(i);
        }

        current.wordIndex = i;
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    private List<Integer> search(String word, int i) {
        List<Integer> ids = new ArrayList<>();
        TrieNode current = root;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            current = current.children[c - 'a'];
            if (current == null) return ids;
            if (current.wordIndex >= 0 && isPalindrome(word, j + 1, word.length() - 1)) {
                ids.add(current.wordIndex);
            }
        }
        if (current.wordIndex >= 0) ids.add(current.wordIndex);
        ids.addAll(current.leftPalindromeWordIds);

        return ids;
    }

    private boolean isPalindrome(String word) {
        return isPalindrome(word, 0, word.length() - 1);
    }

    private boolean isPalindrome(String word, int left, int right) {
        if (left > right) return false;
        while (left < right) if (word.charAt(left++) != word.charAt(right--)) return false;
        return true;
    }

    private List<Integer> getSelfPalindrome(String[] words) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) list.add(i);
        }

        return list;
    }
}
