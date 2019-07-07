package com.leetcode.contest.contest144;

public class No1109CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        final int[] answer = new int[n];
        for (int[] bk : bookings) {
            answer[bk[0] - 1] += bk[2];
            if (bk[1] < n) answer[bk[1]] += -bk[2];
        }

        for (int i = 1; i < n; i++) answer[i] += answer[i - 1];
        return answer;
    }
}
