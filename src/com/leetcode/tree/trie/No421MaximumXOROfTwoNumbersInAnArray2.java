package com.leetcode.tree.trie;

public class No421MaximumXOROfTwoNumbersInAnArray2 {
    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {
        for (int n : nums) insert(n);

        int max = 0;
        for (int n : nums) {
            TrieNode current = root;
            int nextMax = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (current.children[bit] == null) current = current.children[bit ^ 1];
                else {
                    nextMax |= (1 << i);
                    current = current.children[bit];
                }
            }

            max = Math.max(max, nextMax);
            if (max == Integer.MAX_VALUE) break;
        }

        return max;
    }

    private void insert(int n) {
        TrieNode current = root;
        // stars from 30: they are positive number, we don't care about the sign bit.
        for (int i = 30; i >= 0; i--) {
            // we store the number as the XOR result, then we can search directly
            int bit = ((n >> i) & 1) ^ 1;
            if (current.children[bit] == null) current.children[bit] = new TrieNode();
            current = current.children[bit];
        }
    }

    // https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/130427/()-92
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
}
