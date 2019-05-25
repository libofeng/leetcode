package com.leetcode.tree.trie;

import java.util.*;

public class No642DesignSearchAutocompleteSystem {
    private final int k = 3;
    private TrieNode root = new TrieNode();
    private Map<String, Integer> counter = new HashMap<>();
    private StringBuilder inputs = new StringBuilder();

    public No642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            String w = sentences[i];
            counter.put(w, times[i] - 1);
            insert(w);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(inputs.toString());
            inputs.setLength(0);
            return new ArrayList<>();
        }

        inputs.append(c);
        TrieNode current = root;
        for (int i = 0; i < inputs.length(); i++) {
            char ic = inputs.charAt(i);
            if (current.children[ic] == null) return new ArrayList<>();
            current = current.children[ic];
        }
        return current.topWords;
    }

    private void insert(String w) {
        counter.put(w, counter.getOrDefault(w, 0) + 1);

        TrieNode current = root;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (current.children[c] == null) current.children[c] = new TrieNode();
            current = current.children[c];

            if (!current.topWords.contains(w)) current.topWords.add(w);
            maintainTopWords(current);
        }
        current.isWord = true;
    }

    private void maintainTopWords(TrieNode node) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (counter.get(a).equals(counter.get(b))) return a.compareTo(b);
                else return counter.get(b) - counter.get(a);
            }
        };

        node.topWords.sort(comparator);
        if (node.topWords.size() > k) node.topWords.removeLast();
    }

    class TrieNode {
        LinkedList<String> topWords = new LinkedList<>();
        TrieNode[] children = new TrieNode[128];
        boolean isWord;
    }
}
