package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No974SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for (int n : A) {
            sum = (K + (sum + n) % K) % K;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
