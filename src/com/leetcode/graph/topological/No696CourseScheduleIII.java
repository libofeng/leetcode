package com.leetcode.graph.topological;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No696CourseScheduleIII {
    /**
     * @param courses: duration and close day of each course
     * @return: the maximal number of courses that can be taken
     */
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 1) return 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        final PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);

        int time = 0;
        for (int[] d : courses) {
            if (time + d[0] <= d[1]) {
                time += d[0];
                pq.offer(d[0]);
            } else if (!pq.isEmpty() && pq.peek() > d[0]) {
                time += d[0] - pq.poll();
                pq.offer(d[0]);
            }
        }

        return pq.size();
    }
}
