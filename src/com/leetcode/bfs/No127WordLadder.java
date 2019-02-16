package com.leetcode.bfs;

import java.util.*;

public class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> set = new HashSet<>(wordList);
        final Queue<String> q = new LinkedList<>();
        if (!set.contains(endWord)) return 0;

        q.offer(beginWord);
        set.remove(beginWord);

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
                        if (oldC == c) continue;
                        chars[i] = c;

                        String next = new String(chars);
                        if (set.remove(next)) q.offer(next);
                    }
                    chars[i] = oldC;
                }
            }
        }

        return 0;
    }
}
