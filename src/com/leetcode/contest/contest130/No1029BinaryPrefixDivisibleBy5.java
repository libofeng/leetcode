package com.leetcode.contest.contest130;

import java.util.ArrayList;
import java.util.List;

public class No1029BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        final List<Boolean> result = new ArrayList<>();
        long n = 0;
        for (int i : A) {
            n = (n * 2 + i) % 5;
            result.add(n == 0);
        }
        return result;
    }
}
