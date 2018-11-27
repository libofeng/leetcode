package com.lintcode.tree;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
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

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c] == null) return false;
            current = current.children[c];
        }

        return current.isWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;

        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children[c] == null) return false;
            current = current.children[c];
        }

        return true;
    }
}
