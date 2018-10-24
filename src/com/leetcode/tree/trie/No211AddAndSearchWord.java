package com.leetcode.tree.trie;

public class No211AddAndSearchWord {
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public No211AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.children[c - 'a'];
            if (node == null) {
                node = new TrieNode();
                current.children[c - 'a'] = node;
            }

            current = node;
        }

        current.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        return search(word, 0, root);
    }

    private boolean search(String s, int index, TrieNode node) {
        if (node == null) return false;
        if (s.length() == index) return node.isWord;

        char c = s.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) if (search(s, index + 1, child)) return true;
        } else return search(s, index + 1, node.children[c - 'a']);

        return false;
    }
}
