package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

public class No406QueueReconstructionByHeight {
    // https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89359/Explanation-of-the-neat-Sort%2BInsert-solution
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) -> b[0] == a[0] ? (a[1] - b[1]) : (b[0] - a[0]));

        ArrayList<int[]> tmp = new ArrayList<>();
        for (int[] p : people) tmp.add(p[1], new int[]{p[0], p[1]});

        int[][] result = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            result[i][0] = k[0];
            result[i++][1] = k[1];
        }

        return result;
    }
}
