package com.leetcode.contest.contest153;

import java.time.LocalDate;

public class No5183DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        final String[] weeks = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int y = year % 100, m = month, c = year / 100, d = day;
        if (month == 1 || month == 2) {
            y = (year - 1) % 100;
            m = 12 + month;
            c = (year - 1) / 100;
        }

        int w = y + (y / 4) + (c / 4) - 2 * c + (26 * (m + 1) / 10) + d - 1;
        return weeks[(w % 7 + 7) % 7];
    }

    public String dayOfTheWeek2(int day, int month, int year) {
        final String[] weeks = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        LocalDate d = LocalDate.of(year, month, day);
        return weeks[d.getDayOfWeek().getValue() % 7];
    }
}
