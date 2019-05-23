package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] prev = new int[rowIndex + 1], current = new int[rowIndex + 1];
        prev[0] = 1;
        for (int i = 2; i <= rowIndex + 1; i++) {
            for (int j = 0; j < i; j++) {
                int a = j - 1 < 0 ? 0 : prev[j - 1], b = prev[j];
                current[j] = a + b;
            }

            int[] temp = prev;
            prev = current;
            current = temp;
        }

        final List<Integer> result = new ArrayList<>();
        for (int n : prev) result.add(n);
        return result;

    }
}
