package com.leetcode.array;

import java.util.*;

public class No218TheSkylineProblem {
    // Use PriorityQueue
    public List<int[]> getSkyline(int[][] buildings) {
        final List<int[]> list = new ArrayList<>();
        for (int[] p : buildings) {
            list.add(new int[]{p[0], p[2]});
            list.add(new int[]{p[1], -p[2]});
        }

        list.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));
        final Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        final List<int[]> result = new ArrayList<>();

        int last = 0;
        for (int[] p : list) {
            int x = p[0], h = p[1], max = 0;
            if (h > 0) pq.offer(h);
            else pq.remove(-h);

            max = pq.isEmpty() ? 0 : pq.peek();
            if (max != last) {
                result.add(new int[]{x, max});
                last = max;
            }
        }

        return result;
    }

    // Use TreeMap. Since there will be performance problem when removing item from PriorityQueue.
    public List<int[]> getSkyline2(int[][] buildings) {
        final List<int[]> result = new ArrayList<>();
        final List<int[]> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new int[]{b[0], b[2]});
            list.add(new int[]{b[1], -b[2]});
        }
        list.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        // If use a separate comparator will be more efficient by comparing to a lambda
        /*
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0]? (b[1] - a[1]) : (a[0] - b[0]);
            }
        };
         */

        int lastH = 0;

        final TreeMap<Integer, Integer> treemap = new TreeMap<>();
        for (int[] p : list) {
            int x = p[0], h = p[1], maxH = 0;
            if (h > 0) {
                treemap.put(h, treemap.getOrDefault(h, 0) + 1);
                maxH = treemap.lastKey();
            } else {
                h = -h;
                treemap.put(h, treemap.get(h) - 1);
                if (treemap.get(h) == 0) treemap.remove(h);
                maxH = treemap.isEmpty() ? 0 : treemap.lastKey();
            }

            if (maxH != lastH) {
                result.add(new int[]{x, maxH});
                lastH = maxH;
            }
        }

        return result;
    }
}
