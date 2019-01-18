package com.leetcode.string;

import java.util.TreeSet;

public class No681NextClosestTime {
    public String nextClosestTime(String time) {
        TreeSet<Character> set = new TreeSet<>();
        char[] chars = time.toCharArray();
        for (char c : chars) if (':' != c) set.add(c);

        Character c = set.ceiling((char) (chars[4] + 1));
        if (c == null) {
            chars[4] = set.first();

            c = set.ceiling((char) (chars[3] + 1));
            if (c == null || c > '6') {
                chars[3] = set.first();
                chars[4] = set.first();

                c = set.ceiling((char) (chars[1] + 1));
                if (c == null || (10 * (chars[0] - '0') + (c - '0') > 23)) {
                    chars[1] = set.first();

                    c = set.ceiling((char) (chars[0] + 1));
                    if (c == null || c > '2') chars[0] = set.first();
                    else chars[0] = c;

                } else chars[1] = c;

            } else chars[3] = c;

        } else chars[4] = c;

        return new String(chars);
    }

    public static void main(String[] args) {
        No681NextClosestTime solution = new No681NextClosestTime();
        String nextTime = solution.nextClosestTime("19:34");
        System.out.println("nextTime = " + nextTime);
        System.out.println("nextTime = " + "19:39".equals(nextTime));

        nextTime = solution.nextClosestTime("23:59");
        System.out.println("nextTime = " + nextTime);
        System.out.println("nextTime = " + "22:22".equals(nextTime));
    }
}
