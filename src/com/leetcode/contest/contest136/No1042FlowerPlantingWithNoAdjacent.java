package com.leetcode.contest.contest136;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1042FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        final int[] result = new int[N];
        for (int i = 1; i <= N; i++) {
            final Set<Integer> colors = new HashSet<>();
            for (int n : graph.get(i)) if (result[n - 1] > 0) colors.add(result[n - 1]);
            for (int c = 1; c <= 4; c++) {
                if (colors.contains(c)) continue;

                result[i - 1] = c;
                break;
            }
        }

        return result;
    }
}
