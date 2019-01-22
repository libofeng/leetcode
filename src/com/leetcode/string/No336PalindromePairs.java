package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No336PalindromePairs {
    class TrieNode {
        int wordIndex = -1;
        TrieNode[] children = new TrieNode[26];
        List<Integer> leftPalindromeIds = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> slefPalindromeIds = findSelfPalindromeIds(words);

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                for (int id : slefPalindromeIds) {
                    if (id == i) continue;
                    result.add(Arrays.asList(i, id));
                    result.add(Arrays.asList(id, i));
                }
            } else insert(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            for (int id : search(words[i])) if (i != id) result.add(Arrays.asList(i, id));
        }

        return result;
    }

    private void insert(String w, int idx) {
        String sw = reverse(w);

        TrieNode current = root;
        for (int i = 0; i < sw.length(); i++) {
            char c = sw.charAt(i);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            if (isPalindrome(sw, i + 1, sw.length() - 1)) current.leftPalindromeIds.add(idx);
        }

        current.wordIndex = idx;
    }

    private List<Integer> search(String w) {
        List<Integer> ids = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            current = current.children[c - 'a'];
            if (current == null) return ids;

            if (current.wordIndex >= 0 && isPalindrome(w, i + 1, w.length() - 1)) ids.add(current.wordIndex);
        }

        if (current.wordIndex >= 0) ids.add(current.wordIndex);
        ids.addAll(current.leftPalindromeIds);

        return ids;
    }

    private List<Integer> findSelfPalindromeIds(String[] words) {
        final List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < words.length; i++) if (isPalindrome(words[i])) ids.add(i);
        return ids;
    }

    private boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private String reverse(String s) {
        final StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        if (lo > hi) return false;
        while (lo < hi) if (s.charAt(lo++) != s.charAt(hi--)) return false;
        return true;
    }
}
