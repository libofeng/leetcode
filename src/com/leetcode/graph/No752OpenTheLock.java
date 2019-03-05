package com.leetcode.graph;

import java.util.*;

public class No752OpenTheLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        final Set<String> deadendSet = new HashSet<>(), visited = new HashSet<>();
        deadendSet.addAll(Arrays.asList(deadends));

        final Queue<String> q = new LinkedList<>();
        // Note this edge case!!!!
        if (!deadendSet.contains(start)) {
            q.offer(start);
            visited.add(start);
        }

        int turns = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String state = q.poll();
                if (state.equals(target)) return turns;

                char[] chars = state.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];

                    chars[i] = forward(c);
                    String forward = new String(chars);
                    if (!deadendSet.contains(forward) && visited.add(forward)) q.offer(forward);

                    chars[i] = backward(c);
                    String backward = new String(chars);
                    if (!deadendSet.contains(backward) && visited.add(backward)) q.offer(backward);

                    chars[i] = c;
                }
            }
            turns++;
        }

        return -1;
    }

    private char forward(char c) {
        if (c == '9') return '0';
        return (char) (c + 1);
    }

    private char backward(char c) {
        if (c == '0') return '9';
        return (char) (c - 1);
    }
}
