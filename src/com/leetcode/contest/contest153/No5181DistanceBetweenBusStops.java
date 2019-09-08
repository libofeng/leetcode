package com.leetcode.contest.contest153;

public class No5181DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) return distanceBetweenBusStops(distance, destination, start);

        int total = 0, d = 0;
        for (int n : distance) total += n;

        for (int i = start; i < destination; i++) d += distance[i];
        return Math.min(total - d, d);
    }
}
