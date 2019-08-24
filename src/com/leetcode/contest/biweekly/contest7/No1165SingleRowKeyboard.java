package com.leetcode.contest.biweekly.contest7;

public class No1165SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        final int[] p = new int[26];
        for (int i = 0; i < keyboard.length(); i++) p[keyboard.charAt(i) - 'a'] = i;

        int last = 0, time = 0;
        for (char c : word.toCharArray()) {
            int index = p[c - 'a'];
            time += Math.abs(index - last);
            last = index;
        }

        return time;
    }
}
