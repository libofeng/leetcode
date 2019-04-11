package com.leetcode.tree.trie;

import java.util.*;

public class No745PrefixAndSuffixSearch {

    class TrieNode {
        Set<Integer> ids = new HashSet<>();
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode prefixTree = new TrieNode();
    private TrieNode suffixTree = new TrieNode();

    private Map<String, Integer> cache = new HashMap<>();

    public No745PrefixAndSuffixSearch(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertPrefix(words[i], i);
            insertSuffix(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "-" + suffix;
        if (cache.containsKey(key)) return cache.get(key);

        final TreeSet<Integer> prefixWeights = getStartsWithPrefix(prefix);
        final TreeSet<Integer> suffixWeights = getEndsWithSuffix(suffix);

        prefixWeights.retainAll(suffixWeights);
        int maxWeight = prefixWeights.isEmpty() ? -1 : prefixWeights.last();
        cache.put(key, maxWeight);

        return maxWeight;
    }

    private void insertPrefix(String word, int w) {
        TrieNode current = prefixTree;
        current.ids.add(w);

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            current.ids.add(w);
        }
    }

    private void insertSuffix(String word, int w) {
        TrieNode current = suffixTree;
        current.ids.add(w);

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            current.ids.add(w);
        }
    }

    private TreeSet<Integer> getStartsWithPrefix(String prefix) {
        TrieNode current = prefixTree;
        final TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null) return set;
            current = current.children[c - 'a'];
        }

        set.addAll(current.ids);
        return set;
    }

    private TreeSet<Integer> getEndsWithSuffix(String suffix) {
        TrieNode current = suffixTree;
        final TreeSet<Integer> set = new TreeSet<>();

        for (int i = suffix.length() - 1; i >= 0; i--) {
            char c = suffix.charAt(i);
            if (current.children[c - 'a'] == null) return set;
            current = current.children[c - 'a'];
        }

        set.addAll(current.ids);
        return set;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"apple"};
        No745PrefixAndSuffixSearch solution = new No745PrefixAndSuffixSearch(words);
        int i = solution.f("a", "e");
        System.out.println("i = " + i);
    }
}
