package com.leetcode.tree.trie;

import java.util.ArrayList;
import java.util.List;

public class No425WordSquares {
    private TrieNode root = new TrieNode();

    public List<List<String>> wordSquares(String[] words) {
        for (String w : words) insert(w);
        final int n = words[0].length();

        final List<List<String>> result = new ArrayList<>();
        final List<String> list = new ArrayList<>();
        for (String w : words) {
            list.add(w);
            search(result, list, 1, n);
            list.remove(list.size() - 1);
        }

        return result;
    }

    private void search(List<List<String>> result, List<String> list, int k, int total) {
        if (k >= total) {
            result.add(new ArrayList<>(list));
            return;
        }

        TrieNode current = root;
        for (int i = 0; i < k; i++) {
            char c = list.get(i).charAt(k);
            if (current.children[c - 'a'] == null) return;
            current = current.children[c - 'a'];
        }

        for (String w : current.words) {
            list.add(w);
            search(result, list, k + 1, total);
            list.remove(list.size() - 1);
        }
    }

    private void insert(String w) {
        TrieNode current = root;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            current.words.add(w);
        }
        current.isWord = true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> words = new ArrayList<>();
        boolean isWord;
    }
}
