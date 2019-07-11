package com.leetcode.bfs;

import java.util.*;

public class No433MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        final Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;

        final Queue<String> q = new LinkedList<>();
        final char[] choices = new char[]{'A', 'C', 'G', 'T'};

        q.offer(start);
        set.remove(start);

        int mutations = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String gene = q.poll();
                if (end.equals(gene)) return mutations;

                final char[] chars = gene.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char c : choices) {
                        if (origin == c) continue;
                        chars[i] = c;

                        final String next = new String(chars);
                        if (set.remove(next)) q.offer(next);
                    }
                    chars[i] = origin;
                }
            }
            mutations++;
        }

        return -1;
    }
}
