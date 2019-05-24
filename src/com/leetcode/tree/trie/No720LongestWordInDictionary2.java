package com.leetcode.tree.trie;

import java.util.Arrays;

public class No720LongestWordInDictionary2 {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        final TrieNode root = new TrieNode();
        int longest = 0;
        String result = null;
        for (String w : words) {
            TrieNode current = root;

            int i = 0;
            for (; i < w.length(); i++) {
                char c = w.charAt(i);
                if (current.children[c - 'a'] == null) {
                    if (i == w.length() - 1) {
                        current.children[c - 'a'] = new TrieNode();
                        current.children[c - 'a'].isWord = true;
                    } else break;
                } else {
                    if (!current.children[c - 'a'].isWord) break;
                    current = current.children[c - 'a'];
                }
            }
            if (i == w.length() && i > longest) {
                longest = i;
                result = w;
            }
        }

        return result;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}
