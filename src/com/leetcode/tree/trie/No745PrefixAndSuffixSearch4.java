package com.leetcode.tree.trie;

public class No745PrefixAndSuffixSearch4 {
    String[] input;

    // WordFilter: Time = O(1)
    // f: Time = O(NL)
    // Space = O(1)

    public No745PrefixAndSuffixSearch4(String[] words) {
        input = words;
    }

    public int f(String prefix, String suffix) {
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i].startsWith(prefix) && input[i].endsWith(suffix)) return i;
        }
        return -1;
    }
}
