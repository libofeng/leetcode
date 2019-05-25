package com.leetcode.tree.trie;

public class No676ImplementMagicDictionary {

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public No676ImplementMagicDictionary() {
        root = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String w : dict) insert(w);
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return search(root, word, 0, false);
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

    private boolean search(TrieNode node, String w, int start, boolean skipped) {
        if (node == null) return false;
        if (start == w.length()) return skipped && node.isWord;

        char wchar = w.charAt(start++);
        if (skipped) {
            if (search(node.children[wchar - 'a'], w, start, skipped)) return true;
            return false;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (search(node.children[c - 'a'], w, start, c != wchar)) return true;
        }

        return false;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
