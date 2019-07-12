package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No451SortCharactersByFrequency {
    public String frequencySort(String s) {
        final List<int[]> counter = new ArrayList<>();
        for (int i = 0; i < 128; i++) counter.add(new int[]{i, 0});

        for (char c : s.toCharArray()) counter.get(c)[1]++;
        counter.sort((a, b) -> b[1] - a[1]);

        final StringBuilder sb = new StringBuilder();
        for (int[] c : counter) {
            if (c[1] == 0) continue;
            for (int i = 0; i < c[1]; i++) sb.append((char) c[0]);
        }

        return sb.toString();
    }

    public String frequencySort2(String s) {
        final int[] counter = new int[128];
        for (char c : s.toCharArray()) counter[c]++;

        final StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            char max = 0;
            for (char i = 1; i < counter.length; i++) if (counter[i] > counter[max]) max = i;
            while (counter[max]-- > 0) sb.append(max);
        }

        return sb.toString();
    }
}
