package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) row.add(getCell(result, i, j));
            result.add(row);
        }

        return result;
    }

    private int getCell(List<List<Integer>> triangle, int row, int col) {
        if (row == 0) return 1;
        List<Integer> prev = triangle.get(row - 1);
        if (col - 1 < 0) return prev.get(col);
        if (col >= prev.size()) return prev.get(col - 1);

        return prev.get(col - 1) + prev.get(col);
    }
}
