package com.leetcode.contest.biweekly.contest5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No5037ParallelCourses {
    public int minimumSemesters(int N, int[][] relations) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        final int[] inDegree = new int[N];

        for (int[] p : relations) {
            graph.get(p[0] - 1).add(p[1] - 1);
            inDegree[p[1] - 1]++;
        }

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) if (inDegree[i] == 0) q.offer(i);

        int semesters = 0, courses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int c = q.poll();
                courses++;
                for (int next : graph.get(c)) {
                    if (--inDegree[next] == 0) q.offer(next);
                }
            }

            semesters++;
        }

        return courses == N ? semesters : -1;
    }
}
