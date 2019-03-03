package com.leetcode.contest.contest126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        final List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;

        final int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < A[0].length(); i++) c1[A[0].charAt(i) - 'a']++;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) c2[A[i].charAt(j) - 'a']++;

            for (int j = 0; j < 26; j++) c1[j] = Math.min(c1[j], c2[j]);
            Arrays.fill(c2, 0);
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < c1[i]; j++) result.add("" + (char) ('a' + i));
        }

        return result;
    }
}
