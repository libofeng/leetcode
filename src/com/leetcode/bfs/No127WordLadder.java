package com.leetcode.bfs;

import java.util.*;

public class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> dict = new HashSet<>(wordList);
        final Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return len;
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char oldC = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldC) continue;
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        if (dict.contains(nextWord)) {
                            q.offer(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                    wordChars[j] = oldC;
                }
            }
        }

        return 0;
    }
}
