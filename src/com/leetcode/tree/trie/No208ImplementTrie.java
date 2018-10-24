package com.leetcode.tree.trie;

public class No208ImplementTrie {
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[128];
    }

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public No208ImplementTrie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c] == null) current.children[c] = new TrieNode();
            current = current.children[c];
        }

        current.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children[c];
            if (current == null) return false;
        }

        return current.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;

        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.children[c];
            if (current == null) return false;
        }

        return true;
    }
}
