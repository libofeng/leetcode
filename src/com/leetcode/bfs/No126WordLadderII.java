package com.leetcode.bfs;

import java.util.*;

public class No126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> result = new ArrayList<>();
        final Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return result;

        final Queue<List<String>> q = new LinkedList<>();
        List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        q.offer(startPath);

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> used = new HashSet<>();
            while (size-- > 0) {
                List<String> path = q.poll();
                String lastWord = path.get(path.size() - 1);
                if (lastWord.equals(endWord)) {
                    result.add(path);
                    continue;
                }

                char[] chars = lastWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originC = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (originC == c) continue;
                        chars[i] = c;

                        String next = new String(chars);
                        if (dict.contains(next)) {
                            used.add(next);
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(next);
                            q.offer(newPath);
                        }
                    }
                    chars[i] = originC;
                }
            }

            dict.removeAll(used);
            if (result.size() > 0) return result;
        }

        return result;
    }
}
