package com.leetcode.graph;

import java.util.*;

public class No752OpenTheLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        final Queue<String> q = new LinkedList<>();
        final Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains(start)) return -1;

        q.offer(start);
        visited.add(start);

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String state = q.poll();
                if (state.equals(target)) return steps;

                char[] chars = state.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];

                    String next;

                    chars[i] = oldChar == '0' ? '9' : (char) (oldChar - 1);
                    next = new String(chars);
                    if (visited.add(next)) q.offer(next);

                    chars[i] = oldChar == '9' ? '0' : (char) (oldChar + 1);
                    next = new String(chars);
                    if (visited.add(next)) q.offer(next);

                    chars[i] = oldChar;
                }
            }

            steps++;
        }

        return -1;
    }
}
