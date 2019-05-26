package com.leetcode.contest.contest138;

import java.util.*;

public class No1054DistantBarcodes {
    // Time: NLog(N), Space: O(N)
    // similar to TaskSchedule
    public int[] rearrangeBarcodes(int[] barcodes) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : barcodes) map.put(n, map.getOrDefault(n, 0) + 1);
        final Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);

        int index = 0;
        while (!pq.isEmpty()) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) if (!pq.isEmpty()) list.add(pq.poll());

            for (Map.Entry<Integer, Integer> e : list) {
                barcodes[index++] = e.getKey();
                e.setValue(e.getValue() - 1);
                if (e.getValue() > 0) pq.offer(e);
            }
        }

        return barcodes;
    }

    // Permutation
    // Time: O(N!), Space: O(N)
    // TLE, not a good solution
    public int[] rearrangeBarcodes2(int[] barcodes) {
        dfs(barcodes, 0);
        return barcodes;
    }

    private boolean dfs(int[] codes, int start) {
        if (isValid(codes)) return true;

        for (int i = start + 1; i < codes.length; i++) {
            swap(codes, start, i);
            if (dfs(codes, start + 1)) return true;
            swap(codes, start, i);
        }

        return false;
    }

    private boolean isValid(int[] codes) {
        for (int i = 1; i < codes.length; i++) if (codes[i] == codes[i - 1]) return false;
        return true;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
