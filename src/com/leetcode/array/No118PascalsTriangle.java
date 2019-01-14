package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;

        triangle.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1), row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int val = getPrevValue(prevRow, j - 1) + getPrevValue(prevRow, j);
                row.add(val);
            }
            triangle.add(row);
        }

        return triangle;
    }

    private int getPrevValue(List<Integer> row, int i) {
        return i < 0 || i >= row.size() ? 0 : row.get(i);
    }
}
