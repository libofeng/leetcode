package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No630CourseScheduleIII {

    // greedy
    // Time: O(N), Space: O(N)
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int currentTime = 0;
        for (int[] course : courses) {
            currentTime += course[0];
            q.offer(course[0]);
            if(currentTime > course[1])  currentTime -= q.poll();
        }

        return q.size();
    }
}
