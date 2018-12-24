package com.leetcode.graph;

import java.util.*;

public class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            while (size-- > 0) {
                String word = q.poll();
                if (word.equals(endWord)) return level;

                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldC = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldC) continue;

                        chars[i] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);
                        }
                    }

                    chars[i] = oldC;
                }
            }
        }

        return 0;
    }
}
