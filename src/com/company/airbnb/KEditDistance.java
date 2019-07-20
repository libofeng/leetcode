package com.company.airbnb;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {
    // See also:
    // 72. Edit distance
    // 161. One Edit distance

    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        KEditDistance sol = new KEditDistance();
        String[] input = new String[]{"abcd", "abc", "abd", "ad", "c", "cc"};
        String target = "abcd";
        int k = 2;
        List<String> res = sol.getKEditDistance(input, target, k);
        assert (4 == res.size());
    }

    private List<String> getKEditDistance(String[] words, String target, int k) {
        for (String w : words) insert(w);

        final List<String> result = new ArrayList<>();
        final int[] dp = new int[target.length() + 1];
        for (int i = 1; i < dp.length; i++) dp[i] = i;

        search(result, target, k, root, "", dp);
        return result;
    }

    private void search(List<String> result, String target, int k, TrieNode node, String word, int[] dp) {
        if (node.isWord) {
            if (dp[target.length()] > k) return;
            result.add(word);
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (node.children[c] == null) continue;

            final int[] next = new int[dp.length];
            next[0] = word.length() + 1;
            for (int j = 1; j < next.length; j++) {
                if (c == target.charAt(j - 1)) {
                    next[j] = dp[j - 1];
                } else next[j] = 1 + Math.min(dp[j - 1], Math.min(dp[j], next[j - 1]));
            }

            search(result, target, k, node.children[c], word + c, next);
        }
    }

    private void insert(String word) {
        if (word.isEmpty()) return;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c] == null) current.children[c] = new TrieNode();
            current = current.children[c];
        }
        current.isWord = true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[128];
        boolean isWord;
    }
}
