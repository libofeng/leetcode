package com.leetcode.array;

import java.util.*;

public class No218TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        final List<int[]> lines = new ArrayList<>();
        for (int[] building : buildings) {
            lines.add(new int[]{building[0], building[2]});
            lines.add(new int[]{building[1], -building[2]});
        }

        Collections.sort(lines, new Comparator<int[]>() {
            public int compare(int[] A1, int[] A2) {
                return A1[0] == A2[0] ? (A2[1] - A1[1]) : (A1[0] - A2[0]);
            }
        });

        final PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        List<int[]> R = new ArrayList<>();
        int pre = 0;
        for (int[] line : lines) {
            int max;
            if (line[1] > 0) {
                pq.offer(line[1]);
                max = pq.peek();
            } else {
                pq.remove(-line[1]);
                max = pq.isEmpty() ? 0 : pq.peek();
            }

            if (max != pre) {
                R.add(new int[]{line[0], max});
                pre = max;
            }
        }

        return R;
    }
}
