package com.leetcode.greedy;

import java.util.*;

public class No621TaskScheduler {
    // https://leetcode.com/problems/task-scheduler/discuss/104496/concise-java-solution-on-time-o26-space
    public int leastInterval(char[] tasks, int n) {
        final int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;

        int max = count[0], num = 1;
        for (int i = 1; i < 26; i++) {
            if (max == count[i]) num++;
            else if (count[i] > max) {
                max = count[i];
                num = 1;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + num);
    }

    // https://leetcode.com/problems/task-scheduler/discuss/104496/concise-java-solution-on-time-o26-space
    public int leastInterval2(char[] tasks, int n) {
        final int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;

        int max = 0, num = 0;
        for (int c : count) {
            if (c == max) num++;
            else if (c > max) {
                max = c;
                num = 1;
            }
        }

        int idleSlots = (max - 1) * (n - (num - 1));
        int taskLeft = tasks.length - max * num;
        int idleLeft = Math.max(0, idleSlots - taskLeft);

        return tasks.length + idleLeft;
    }

    // https://leetcode.com/problems/task-scheduler/discuss/104493/c-java-clean-code-priority-queue
    public int leastInterval3(char[] tasks, int n) {
        final Map<Character, Integer> count = new HashMap<>();
        for (char c : tasks) count.put(c, count.getOrDefault(c, 0) + 1);

        final PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pq.addAll(count.values());

        final int blockSize = n + 1;
        int totalSlots = 0;
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < blockSize; i++) if (!pq.isEmpty()) tmp.add(pq.poll());
            for (int c : tmp) if (--c > 0) pq.offer(c);

            totalSlots += pq.isEmpty() ? tmp.size() : blockSize;
        }

        return totalSlots;
    }
}
