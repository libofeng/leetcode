package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class No54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int colStart = 0, colEnd = n - 1, rowStart = 0, rowEnd = m - 1;

        while (colStart <= colEnd && rowStart <= rowEnd) {
            // top
            for (int i = colStart; i <= colEnd; i++) list.add(matrix[rowStart][i]);

            // right
            for (int i = rowStart + 1; i < rowEnd; i++) list.add(matrix[i][colEnd]);

            // bottom
            if (rowEnd - rowStart > 0) {
                for (int i = colEnd; i >= colStart; i--) list.add(matrix[rowEnd][i]);
            }

            // left
            if (colEnd - colStart > 0) {
                for (int i = rowEnd - 1; i > rowStart; i--) list.add(matrix[i][colStart]);
            }

            colStart++;
            colEnd--;
            rowStart++;
            rowEnd--;
        }

        return list;
    }
}
