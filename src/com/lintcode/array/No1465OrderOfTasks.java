package com.lintcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No1465OrderOfTasks {
    class Point {
        int t, idx;
        double p, r;

        Point(int idx, int t, double p) {
            this.idx = idx;
            this.t = t;
            this.p = p;
            this.r = ((double) t) / p;
        }
    }

    /**
     * @param n: The number of tasks
     * @param t: The time array t
     * @param p: The probability array p
     * @return: Return the order
     */
    public int[] getOrder(int n, int[] t, double[] p) {
        final PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.r == o2.r) return o1.idx - o2.idx;
                return o1.r < o2.r ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) pq.offer(new Point(i + 1, t[i], p[i]));

        final int[] R = new int[n];
        for (int i = 0; i < n; i++) R[i] = pq.poll().idx;
        return R;
    }
}
