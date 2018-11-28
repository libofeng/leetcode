package com.lintcode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No120WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        final Queue<String> q = new LinkedList<>();
        q.offer(start);
        dict.add(end);

        int count = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            count++;
            for (int i = 0; i < len; i++) {
                String w = q.poll();
                if (end.equals(w)) return count;

                char[] chars = w.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldC = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldC) continue;

                        chars[j] = c;
                        String newWord = new String(chars);
                        if (dict.contains(newWord)) {
                            q.offer(newWord);
                            dict.remove(newWord);
                        }
                    }

                    chars[j] = oldC;
                }
            }
        }

        return 0;
    }
}
