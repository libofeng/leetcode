package com.leetcode.contest.contest149;

public class No1154DayOfTheYear {
    public int dayOfYear(String date) {
        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final String[] data = date.split("-");
        final int year = Integer.parseInt(data[0]), month = Integer.parseInt(data[1]);

        int dayOfYear = Integer.parseInt(data[2]);
        for (int m = 0; m < month - 1; m++) {
            if (m == 1) dayOfYear += isLeap(year) ? 29 : 28;
            else dayOfYear += days[m];
        }

        return dayOfYear;
    }

    private boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }
}
