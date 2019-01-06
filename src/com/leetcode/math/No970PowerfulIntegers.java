package com.leetcode.math;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class No970PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<>();
        BitSet bitSet = new BitSet(bound + 1);
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j <= bound - i; j *= y) {
                int n = i + j;
                if (!bitSet.get(n)) result.add(n);
                bitSet.set(n);
                if (y == 1) break;
            }
            if (x == 1) break;
        }

        return result;
    }
}
