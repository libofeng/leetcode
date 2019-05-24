package com.leetcode.tree.trie;

public class No677MapSumPairs {
    /**
     * Initialize your data structure here.
     */
    private TrieNode root = new TrieNode();

    public No677MapSumPairs() {

    }

    public void insert(String key, int val) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (current.children[c] == null) current.children[c] = new TrieNode();
            current = current.children[c];
        }
        current.val = val;
    }

    public int sum(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c] == null) return 0;

            current = current.children[c];
        }

        return dfs(current);
    }

    private int dfs(TrieNode root) {
        if (root == null) return 0;
        int sum = root.val;
        for (TrieNode node : root.children) {
            if (node == null) continue;
            sum += dfs(node);
        }

        return sum;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[128];
        int val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
