package com.leetcode.tree.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No720LongestWordInDictionary {
    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        No720LongestWordInDictionary solution = new No720LongestWordInDictionary();
        String word = solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
        System.out.println("word = " + word);
    }

    // Time: O(N), Space: O(N*W)
    public String longestWord(String[] words) {
        for (String w : words) insert(w);

        return dfs(root, "");
    }

    private String dfs(TrieNode node, String word) {
        if (root == null) return word;
        if (node != root && !node.isWord) return word;

        String next = word;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] == null) continue;

            char c = (char) (i + 'a');
            String w = dfs(node.children[i], word + c);
            if (w == null || w.equals(next)) continue;

            if (w.length() > next.length()) next = w;
            else next = w.compareTo(next) < 0 ? w : next;
        }

        return next;
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

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    // Time: O(NLogN), Space: O(N*W)
    public String longestWord2(String[] words) {
        Arrays.sort(words);
        final Set<String> set = new HashSet<>();

        String result = "";
        set.add(result);

        for (String w : words) {
            if (!set.contains(w.substring(0, w.length() - 1))) continue;

            set.add(w);
            if (w.length() > result.length()) result = w;
        }

        return result;
    }
}
