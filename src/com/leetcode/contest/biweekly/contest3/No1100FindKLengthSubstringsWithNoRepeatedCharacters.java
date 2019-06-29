package com.leetcode.contest.biweekly.contest3;

public class No1100FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) return 0;

        final int[] counter = new int[128];

        int distinct = 0, total = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (counter[c]++ == 0) distinct++;

            if (i >= K - 1) {
                if (distinct == K) total++;
                c = S.charAt(i - K + 1);
                if (--counter[c] == 0) distinct--;
            }
        }

        return total;
    }
}
