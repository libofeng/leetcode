package com.leetcode.tree.trie;

import java.util.LinkedList;

public class No1032StreamOfCharacters {
    private TrieNode root = new TrieNode();
    private LinkedList<Character> query = new LinkedList<>();
    private int maxLen = 0;
    public No1032StreamOfCharacters(String[] words) {
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());
            insert(w);
        }
    }

    public boolean query(char letter) {
        query.addFirst(letter);
        while (query.size() > maxLen) query.removeLast();

        TrieNode current = root;
        for (char c : query) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
            if (current.isWord) return true;
        }

        return false;
    }

    private void insert(String w) {
        TrieNode current = root;
        for (int i = w.length() - 1; i >= 0; i--) {
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
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
