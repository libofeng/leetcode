package com.leetcode.math;

public class No423ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        final int[] counter = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') counter[0]++;
            if (c == 'w') counter[2]++;
            if (c == 'u') counter[4]++;
            if (c == 'x') counter[6]++;
            if (c == 'g') counter[8]++;
            if (c == 'o') counter[1]++; // 0-1-2-4
            if (c == 'h') counter[3]++; // 3 - 8
            if (c == 'f') counter[5]++; // 4 - 5
            if (c == 's') counter[7]++; // 6 - 7
            if (c == 'i') counter[9]++; // 5-6-8-9
        }

        counter[7] -= counter[6];
        counter[5] -= counter[4];
        counter[3] -= counter[8];
        counter[9] -= counter[5] + counter[6] + counter[8];
        counter[1] -= counter[0] + counter[2] + counter[4];

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < counter[i]; j++) sb.append(i);
        }

        return sb.toString();
    }
}
