package com.leetcode.bfs;

import java.util.*;

public class No126WordLadderII {
    class Node {
        String s;
        Node prev;

        Node(String s, Node prev) {
            this.s = s;
            this.prev = prev;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> R = new LinkedList<>();
        final Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return R;

        final Queue<Node> q = new LinkedList<>();
        final List<Node> matched = new LinkedList<>();
        q.offer(new Node(beginWord, null));
        boolean found = false;

        while (!q.isEmpty()) {
            final int size = q.size();
            final Set<String> used = new HashSet<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (endWord.equals(node.s)) {
                    matched.add(node);
                    found = true;
                }
                if (found) continue;

                char[] wordChars = node.s.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char oldC = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldC) continue;

                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        if (dict.contains(nextWord)) {
                            used.add(nextWord);
                            q.offer(new Node(nextWord, node));
                        }
                    }

                    wordChars[j] = oldC;
                }
            }

            dict.removeAll(used);
        }

        for (Node node : matched) {
            LinkedList<String> list = new LinkedList<>();
            while (node != null) {
                list.addFirst(node.s);
                node = node.prev;
            }
            R.add(list);
        }
        return R;
    }
}
