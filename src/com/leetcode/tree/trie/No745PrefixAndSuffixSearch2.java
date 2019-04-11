package com.leetcode.tree.trie;

import java.util.*;

public class No745PrefixAndSuffixSearch2 {

    HashMap<String, Integer> map = new HashMap<>();

    // WordFilter: Time = O(NL^2)
    // f: Time = O(1)
    // Space = O(NL^2)
    public No745PrefixAndSuffixSearch2(String[] words) {
        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
                for (int j = 0; j <= 10 && j <= words[w].length(); j++) {
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length() - j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}
