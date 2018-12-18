package com.lintcode.array;

import java.util.*;

public class No131TheSkylineProblem {
    // reference: https://www.jianshu.com/p/ef44e79462e8
    public List<List<Integer>> buildingOutline2(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new int[]{b[0], b[2]});
            list.add(new int[]{b[1], -b[2]});
        }
        list.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int start = 0, max = 0;
        List<List<Integer>> R = new LinkedList<>();
        for (int[] point : list) {
            int x = point[0], h = point[1];
            if (h > 0) map.put(h, map.getOrDefault(h, 0) + 1);
            else {
                h = -h;
                if (map.get(h) == 1) map.remove(h);
                else map.put(h, map.get(h) - 1);
            }

            int currentMax = map.isEmpty() ? 0 : map.lastKey();
            if (currentMax != max) {
                if (x != start && max != 0) R.add(Arrays.asList(start, x, max));

                max = currentMax;
                start = x;
            }
        }

        return R;
    }


    // copied from solution in leetcode, it will timeout since using PriorityQueue
    public List<List<Integer>> buildingOutline3(int[][] buildings) {
        final List<int[]> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], building[2]});
            list.add(new int[]{building[1], -building[2]});
        }
        list.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        final List<List<Integer>> R = new LinkedList<>();
        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int start = 0, max = 0;
        for (int[] point : list) {
            int x = point[0], h = point[1];

            if (h > 0){ pq.offer(h);}
            else{ pq.remove(-h);}

            int currentMax = pq.isEmpty() ? 0 : pq.peek();

            if (currentMax != max) {
                if (max > 0 && x != start) R.add(Arrays.asList(start, x, max));

                max = currentMax;
                start = x;
            }
        }

        return R;
    }
}
