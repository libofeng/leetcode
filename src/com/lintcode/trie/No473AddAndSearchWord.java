package com.lintcode.trie;

public class No473AddAndSearchWord {
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) p.children[index] = new TrieNode();
            p = p.children[index];
        }

        p.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        return search(word, root, 0);
    }

    private boolean search(String W, TrieNode N, int i) {
        if (N == null) return false;
        if (i == W.length()) return N.isWord;

        int index = W.charAt(i) - 'a';
        if (W.charAt(i) == '.') {
            for (TrieNode node : N.children) if (search(W, node, i + 1)) return true;
        } else return search(W, N.children[index], i + 1);

        return false;
    }
}
