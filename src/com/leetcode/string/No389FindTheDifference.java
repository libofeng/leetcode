package com.leetcode.string;

public class No389FindTheDifference {
    public char findTheDifference(String s, String t) {
        final int[] counter = new int[128];
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++) if (--counter[t.charAt(i)] < 0) return t.charAt(i);

        return 0;
    }

    public char findTheDifference2(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += (t.charAt(i) - s.charAt(i));

        return (char) (sum + t.charAt(t.length() - 1));
    }
}
