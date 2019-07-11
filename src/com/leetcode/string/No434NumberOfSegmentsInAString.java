package com.leetcode.string;

public class No434NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null) return 0;

        s = s.trim();
        return s.isEmpty() ? 0 : s.split(" +").length;
    }

    public int countSegments2(String s) {
        if (s == null) return 0;

        int lastIndex = -1, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') lastIndex = i;
            else if (lastIndex + 1 == i) count++;
        }

        return count;
    }
}
