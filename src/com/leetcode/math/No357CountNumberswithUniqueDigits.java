package com.leetcode.math;

public class No357CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int result = 10, uniqueNumber = 9, numberAvailable = 9;
        while (n-- > 1 && numberAvailable >= 0) result += (uniqueNumber *= numberAvailable--);
        return result;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) return 1;

        int result = 10, base = 9;
        for (int i = 2; i <= Math.min(n, 10); i++) result += (base *= (10 - i + 1));
        return result;
    }
}
