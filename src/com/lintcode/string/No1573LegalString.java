package com.lintcode.string;

import java.util.Arrays;

public class No1573LegalString {
    /**
     * @param k: The necessary distance of same kind of letters
     * @param S: The original string
     * @return: Return the number of '_' inserted before each position of the original string
     */
    public int[] getAns(int k, String S) {
        final int n = S.length();
        final int[] indexs = new int[n], R = new int[n];
        Arrays.fill(indexs, -1);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = count + i;
            char c = S.charAt(i);
            if (indexs[c - 'A'] == -1) {
                indexs[c - 'A'] = index;
                continue;
            }

            int preIndex = indexs[c - 'A'], distance = index - preIndex, gap = k - distance;
            if (gap > 0) {
                count += gap;
                R[i] = gap;
                indexs[c - 'A'] = count + i;
            } else indexs[c - 'A'] = index;
        }

        return R;
    }
}
